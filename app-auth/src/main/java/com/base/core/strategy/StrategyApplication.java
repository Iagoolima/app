package com.base.core.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyApplication {

	private List<IStrategy> strategies;

	public StrategyApplication(List<IStrategy> strategies) {
		this.strategies = new ArrayList<>(strategies);
	}

	public void executeStrategies() {
		for (IStrategy strategy : strategies) {
			if (strategy == null)
				throw new RuntimeException("Class not strategy");

			strategy.execute();
		}
	}

}
