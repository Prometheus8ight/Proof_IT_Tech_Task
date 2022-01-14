package proof_it.tech_task.core.premium_calculator;

import proof_it.tech_task.core.domain.Policy;

public interface PremiumCalculator {
    Double calculate(Policy policy);
}
