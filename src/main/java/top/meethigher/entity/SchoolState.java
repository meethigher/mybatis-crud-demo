package top.meethigher.entity;

/**
 * 学校状态
 *
 * @author chenchuancheng
 * @since 2022/9/13 15:45
 */
public enum SchoolState {
    ENABLE(0,"启用"),
    DISABLE(1,"停用")
    ;

    private final int code;

    private final String name;

    SchoolState(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
