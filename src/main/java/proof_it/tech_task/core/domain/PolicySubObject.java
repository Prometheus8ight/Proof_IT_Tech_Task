package proof_it.tech_task.core.domain;

import proof_it.tech_task.core.risk_type.RiskType;

import java.util.Objects;

public class PolicySubObject {
    private String subObjectName;
    private double sumInsured;
    private RiskType riskType;

    public PolicySubObject(String subObjectName, double sumInsured, RiskType riskType) {
        this.subObjectName = subObjectName;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    public String getSubObjectName() {
        return subObjectName;
    }

    public void setSubObjectName(String subObjectName) {
        this.subObjectName = subObjectName;
    }

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicySubObject that = (PolicySubObject) o;
        return Double.compare(that.sumInsured, sumInsured) == 0 && Objects.equals(subObjectName, that.subObjectName) && riskType == that.riskType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subObjectName, sumInsured, riskType);
    }

    @Override
    public String toString() {
        return "PolicySubObject{" +
                "subObjectName='" + subObjectName + '\'' +
                ", sumInsured=" + sumInsured +
                ", riskType=" + riskType +
                '}';
    }
}

