package com.work.bean;

/**
 * 用于从前端接受传递的审核结果的信息.
 */
public class AuditResult {
    private  Integer result;//审核的结果,1位通过,0为不通过.
    private String remark;//审核意见,即备注.

    @Override
    public String toString() {
        return "AuditResult{" +
                "result=" + result +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
