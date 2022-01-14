package proof_it.tech_task.core.calculator_actions.fire_case_calculations;

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

import static org.junit.jupiter.api.Assertions.*;

class SumFireCaseTest {

    @Mock
    private SumFireCase sumFireCase;

    @BeforeEach
    void setUp() {
        sumFireCase = new SumFireCase();
    }

    @Test
    public void sumInsFire100(){
        PolicySubObject subObject1 = new PolicySubObject("TV", 100.00, RiskType.FIRE);
        PolicySubObject subObject2 = new PolicySubObject("Fridge", 8.00, RiskType.THEFT);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject1);
        policySubObjects.add(subObject2);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Double result = sumFireCase.calculate(policy);
        assertEquals(result, 100);
    }

    @Test
    public void sumInsFire400And100(){
        PolicySubObject subObject1 = new PolicySubObject("TV", 400.00, RiskType.FIRE);
        PolicySubObject subObject2 = new PolicySubObject("Fridge", 8.00, RiskType.THEFT);
        PolicySubObject subObject3 = new PolicySubObject("Coffee Machine", 100, RiskType.FIRE);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject1);
        policySubObjects.add(subObject2);
        policySubObjects.add(subObject3);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Double result = sumFireCase.calculate(policy);
        assertEquals(result, 500);
    }

    @Test
    public void sumInsFire0(){
        PolicySubObject subObject = new PolicySubObject("Fridge", 8.00, RiskType.THEFT);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Double result = sumFireCase.calculate(policy);
        assertEquals(result, 0);
    }
}