
package org.mule.modules.restroomfinder.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.restroomfinder.RestroomFinderConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>RestroomFinderConnectorProcessAdapter</code> is a wrapper around {@link RestroomFinderConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-08-26T02:49:12-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class RestroomFinderConnectorProcessAdapter
    extends RestroomFinderConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<RestroomFinderConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, RestroomFinderConnectorCapabilitiesAdapter> getProcessTemplate() {
        final RestroomFinderConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,RestroomFinderConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, RestroomFinderConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, RestroomFinderConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
