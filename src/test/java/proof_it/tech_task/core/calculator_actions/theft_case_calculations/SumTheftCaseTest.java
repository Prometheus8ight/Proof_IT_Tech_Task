package proof_it.tech_task.core.calculator_actions.theft_case_calculations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import proof_it.tech_task.core.domain.Policy;
import proof_it.tech_task.core.domain.PolicyObject;
import proof_it.tech_task.core.domain.PolicySubObject;
import proof_it.tech_task.core.risk_type.RiskType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTheftCaseTest {

    @Mock private SumTheftCase sumTheftCase;

    @BeforeEach
    void setUp() {
        sumTheftCase = new SumTheftCase();
    }

    @Test
    public void sumInsuredTheft8(){
        PolicySubObject subObject1 = new PolicySubObject("TV", 100.00, RiskType.FIRE);
        PolicySubObject subObject2 = new PolicySubObject("Fridge", 8.00, RiskType.THEFT);
        PolicySubObject subObject3 = new PolicySubObject("Coffee Machine", 50, RiskType.FIRE);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject1);
        policySubObjects.add(subObject2);
        policySubObjects.add(subObject3);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Double result = sumTheftCase.calculate(policy);
        assertEquals(result, 8);
    }

    @Test
    public void sumInsuredTheft80And32_51(){
        PolicySubObject subObject1 = new PolicySubObject("TV", 100.00, RiskType.FIRE);
        PolicySubObject subObject2 = new PolicySubObject("Fridge", 80, RiskType.THEFT);
        PolicySubObject subObject3 = new PolicySubObject("Coffee Machine", 22.51, RiskType.THEFT);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject1);
        policySubObjects.add(subObject2);
        policySubObjects.add(subObject3);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Double result = sumTheftCase.calculate(policy);
        assertEquals(result, 102.51);
    }

    @Test
    public void sumInsuredTheft0(){
        PolicySubObject subObject1 = new PolicySubObject("TV", 100.00, RiskType.FIRE);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject1);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Double result = sumTheftCase.calculate(policy);
        assertEquals(result, 0);
    }
}