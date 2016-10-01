package com.common.mybatis.typehandler;

import com.common.business.user.Role;
import com.common.store.UniqueStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoleListTypeHandler<E extends Enum<Role>> extends BaseTypeHandler<List<Role>> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<Role> roleList, JdbcType jdbcType) throws SQLException {
		ArrayList<String> roles = new ArrayList<>();
		for (Role role: roleList){
			String roleId = String.valueOf(role.getValue());
			// add role only if not already present
			if( !roles.contains(roleId) )
			{
				roles.add(roleId);
			}
		}
		ps.setString(i, StringUtils.join(roles, UniqueStore.COMMA_DELIMITER));
	}

	@Override
	public List<Role> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String roles = rs.getString(columnName);
		return getRoleListFromResultString(roles);
	}

	@Override
	public List<Role> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return getRoleListFromResultString(rs.getString(columnIndex));
	}

	@Override
	public List<Role> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return getRoleListFromResultString(cs.getString(columnIndex));
	}

	private List<Role> getRoleListFromResultString(String result)
	{
		ArrayList<Role> roleList = new ArrayList();
		List<String> roles = Arrays.asList(result.split("\\s*,\\s*"));

		for (String role : roles)
		{
			roleList.add( Role.getRoleFromValue(Integer.parseInt(role)) );
		}
		return roleList;
	}
}
