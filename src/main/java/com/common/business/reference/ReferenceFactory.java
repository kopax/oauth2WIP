package com.common.business.reference;


import com.common.service.reference.ReferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO : finish this class
// NOTE : references should be loaded ONCE at application boot
// referenceFactory will be used to build the reference object.
public class ReferenceFactory
{

	private static final Logger logger = LoggerFactory.getLogger(ReferenceFactory.class);

	public static Reference buildReference( /*Employee currentOperator*/ ) throws IllegalStateException
	{
		final Reference reference = new Reference( /*currentOperator*/ );
		try
		{
			ReferenceService referenceService = new ReferenceService();
			reference.setTypeEmployeeList( referenceService.getTypeEmployeeList() );


		}
		catch ( Exception e )
		{
			logger.error( "Can't get the references" );
			logger.error( e.getMessage() );
			throw new IllegalStateException();
		}
		return reference;
	}
}
