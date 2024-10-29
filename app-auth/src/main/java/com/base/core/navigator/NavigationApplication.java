package com.base.core.navigator;

import com.base.core.strategy.IStrategy;
import com.base.core.strategy.StrategyApplication;

import java.util.Arrays;
import java.util.List;

public class NavigationApplication {

	public void navigatorExecute(IStrategy... strategies) {
		List<IStrategy> execute = Arrays.asList(strategies);
		StrategyApplication strategyApplicationExecutor = new StrategyApplication(execute);
		strategyApplicationExecutor.executeStrategies();
	}

}
