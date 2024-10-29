package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.CheckCodeForgotPasswordBusinessData;
import com.base.core.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class CheckerTimerForgotPasswordStrategy implements IStrategy {

	@Autowired
	private MessageAuth messageAuth;

	@Value("${timer.expiration.forgot-password}")
	private int expirationTime;

	@Override
	public void execute() {

		CheckCodeForgotPasswordBusinessData businessData = CheckCodeForgotPasswordBusinessData
			.getStaticInstance(CheckCodeForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			LocalDateTime dateTimeInsertion = businessData.getCheckCodeForgotPassword().getInsertionTime();
			LocalDateTime dateTimeData = businessData.getForgotPasswordData().getRecordedTime();

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
