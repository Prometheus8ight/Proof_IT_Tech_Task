package proof_it.tech_task.core.domain;

import java.util.List;
import java.util.Objects;

public class PolicyObject {
    private String objectName;
    private List<PolicySubObject> policySubObjects;

    public PolicyObject(String objectName, List<PolicySubObject> policySubObjects) {
        this.objectName = objectName;
        this.policySubObjects = policySubObjects;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<PolicySubObject> getPolicySubObjects() {
        return policySubObjects;
    }

    public void setPolicySubObjects(List<PolicySubObject> policySubObjects) {
        this.policySubObjects = policySubObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicyObject that = (PolicyObject) o;
        return Objects.equals(objectName, that.objectName) && Objects.equals(policySubObjects, that.policySubObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectName, policySubObjects);
    }

    @Override
    public String toString() {
        return "PolicyObject{" +
                "objectName='" + objectName + '\'' +
                ", policySubObjects=" + policySubObjects +
                '}';
    }
}
