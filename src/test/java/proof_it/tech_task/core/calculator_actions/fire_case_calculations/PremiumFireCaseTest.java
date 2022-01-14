package proof_it.tech_task.core.calculator_actions.fire_case_calculations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import proof_it.tech_task.core.domain.Policy;
import proof_it.tech_task.core.domain.PolicyObject;
import proof_it.tech_task.core.domain.PolicySubObject;
import proof_it.tech_task.core.risk_type.RiskType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PremiumFireCaseTest {

    @Mock private SumFireCase sumFireCaseTest;
    @InjectMocks private PremiumFireCase calculatePremiumFire;

    @Test
    public void CalculatePremiumFire100(){
        PolicySubObject subObject1 = new PolicySubObject("TV", 100.00, RiskType.FIRE);
        PolicySubObject subObject2 = new PolicySubObject("Fridge", 8.00, RiskType.THEFT);
        PolicySubObject subObject3 = new PolicySubObject("Coffee Machine", 50, RiskType.THEFT);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject1);
        policySubObjects.add(subObject2);
        policySubObjects.add(subObject3);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Mockito.when(sumFireCaseTest.calculate(policy)).thenReturn(100D);

        Double result = calculatePremiumFire.calculate(policy);
        assertEquals(result, 1.4);
    }

    @Test
    public void CalculatePremiumFire500(){
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

        Mockito.when(sumFireCaseTest.calculate(policy)).thenReturn(500D);

        Double result = calculatePremiumFire.calculate(policy);
        assertEquals(result, 12.0);
    }

    @Test
    public void CalculatePremium0(){
        PolicySubObject subObject = new PolicySubObject("Fridge", 8.00, RiskType.THEFT);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Mockito.when(sumFireCaseTest.calculate(policy)).thenReturn(0D);

        Double result = calculatePremiumFire.calculate(policy);
        assertEquals(result, 0);
    }
}