package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.CheckCodeValidateEmailBusinessData;
import com.base.core.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class CheckerTimerValidateEmailStrategy implements IStrategy {

	@Autowired
	private MessageAuth messageAuth;

	@Value("${timer.expiration.validate-email}")
	private int expirationTime;

	@Override
	public void execute() {

		CheckCodeValidateEmailBusinessData businessData = CheckCodeValidateEmailBusinessData
			.getStaticInstance(CheckCodeValidateEmailBusinessData.class);

		if (!businessData.isError()) {

			LocalDateTime dateTimeInsertion = businessData.getCheckCodeValidateEmail().getDateTime();
			LocalDateTime dateTimeData = businessData.getValidateEmailData().getRecordedTime();

			if (dateTimeInsertion.toLocalDate().isEqual(dateTimeData.toLocalDate())) {

				Duration duration = Duration.between(dateTimeData, dateTimeInsertion);

				if (duration.toMinutes() > expirationTime)
					businessData.setError(messageAuth.ERROR_TIMER_EXCEEDED);

			}
			else {
				businessData.setError(messageAuth.ERROR_TIMER_EXCEEDED);
			}
		}
	}

}
