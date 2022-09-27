package com.shk.pojo;

/**
 * @author: sunhengkang
 * @date:2022/9/24
 */
public class DisallowWord {
    private Integer id;
    private String sensitiveword;
    private Integer type;

    public DisallowWord(Integer id, String sensitiveword, Integer type) {
        this.id = id;
        this.sensitiveword = sensitiveword;
        this.type = type;
    }

    @Override
    public String toString() {
        return "DisallowWord{" +
                "id=" + id +
                ", sensitiveword='" + sensitiveword + '\'' +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSensitiveword() {
        return sensitiveword;
    }

    public void setSensitiveword(String sensitiveword) {
        this.sensitiveword = sensitiveword;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
