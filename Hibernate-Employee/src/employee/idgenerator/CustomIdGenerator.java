package employee.idgenerator;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class CustomIdGenerator extends SequenceStyleGenerator{
	
	public static final String PREFIX = "prefix";
	public static final String DEFAULT = "";
	private String prefix;
	
	public static final String NUMBERFORMAT = "numberFormat";
	public static final String NDEFAULT = "%d";
	private String numberFormat;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException{
		return prefix
				+ String.format(numberFormat, super.generate(session, object));
	}
	
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException{
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		prefix= ConfigurationHelper.getString(PREFIX,params,DEFAULT);
		numberFormat =  ConfigurationHelper.getString(NUMBERFORMAT,params,NDEFAULT);
	}
	

}
