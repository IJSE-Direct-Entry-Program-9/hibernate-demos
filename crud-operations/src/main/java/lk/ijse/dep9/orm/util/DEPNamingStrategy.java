package lk.ijse.dep9.orm.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class DEPNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
        return new Identifier(logicalName.getText().toUpperCase(), false);
    }
}
