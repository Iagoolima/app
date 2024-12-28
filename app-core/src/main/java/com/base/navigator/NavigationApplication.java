package com.base.navigator;

import com.base.strategy.IStrategy;
import com.base.strategy.StrategyApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class NavigationApplication {

    public void navigatorExecute(IStrategy... strategies) {
        List<IStrategy> execute = Arrays.asList(strategies);
        StrategyApplication strategyApplicationExecutor = new StrategyApplication(execute);
        strategyApplicationExecutor.executeStrategies();
    }
}
