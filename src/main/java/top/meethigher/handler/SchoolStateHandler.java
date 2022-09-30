package top.meethigher.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import top.meethigher.entity.SchoolState;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 枚举转换
 *
 * @author chenchuancheng
 * @since 2022/9/30 11:20
 */
public class SchoolStateHandler extends BaseTypeHandler<SchoolState> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SchoolState parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public SchoolState getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return findStateByCode(rs.getInt(columnName));
    }

    @Override
    public SchoolState getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return findStateByCode(rs.getInt(columnIndex));
    }

    @Override
    public SchoolState getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return findStateByCode(cs.getInt(columnIndex));
    }


    private SchoolState findStateByCode(int code) {
        for (SchoolState x : SchoolState.values()) {
            if (code == x.getCode()) {
                return x;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型");
    }
}
