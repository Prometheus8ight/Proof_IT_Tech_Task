package proof_it.tech_task.core.domain;

import java.util.List;
import java.util.Objects;

public class Policy {
    private String PolicyNumber;
    private String policyStatus;
    private List<PolicyObject> policyObject;

    public Policy(String policyNumber, String policyStatus, List<PolicyObject> policyObject) {
        this.PolicyNumber = policyNumber;
        this.policyStatus = policyStatus;
        this.policyObject = policyObject;
    }

    public String getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        PolicyNumber = policyNumber;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public List<PolicyObject> getPolicyObject() {
        return policyObject;
    }

    public void setPolicyObject(List<PolicyObject> policyObject) {
        this.policyObject = policyObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(PolicyNumber, policy.PolicyNumber) && Objects.equals(policyStatus, policy.policyStatus) && Objects.equals(policyObject, policy.policyObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PolicyNumber, policyStatus, policyObject);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "PolicyNumber='" + PolicyNumber + '\'' +
                ", policyStatus='" + policyStatus + '\'' +
                ", policyObject=" + policyObject +
                '}';
    }
}