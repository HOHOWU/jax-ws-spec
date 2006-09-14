/*
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.xml.ws;

import java.security.Principal;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.w3caddressing.W3CEndpointReference;

/**
 *  A <code>WebServiceContext</code> makes it possible for
 *  a web service endpoint implementation class to access
 *  message context and security information relative to
 *  a request being served.
 *
 *  Typically a <code>WebServiceContext</code> is injected
 *  into an endpoint implementation class using the
 *  <code>Resource</code> annotation.
 *
 *  @since JAX-WS 2.0
 *
 *  @see javax.annotation.Resource
 **/
public interface WebServiceContext {
    
    /**
     *  Returns the MessageContext for the request being served
     *  at the time this method is called. Only properties with
     *  APPLICATION scope will be visible to the application.
     *
     *  @return MessageContext The message context.
     *
     *  @throws IllegalStateException This exception is thrown
     *          if the method is called while no request is
     *          being serviced.
     *
     *  @see javax.xml.ws.handler.MessageContext
     *  @see javax.xml.ws.handler.MessageContext.Scope
     *  @see java.lang.IllegalStateException
     **/
    public MessageContext getMessageContext();
    
    /**
     *  Returns the Principal that identifies the sender
     *  of the request currently being serviced. If the
     *  sender has not been authenticated, the method
     *  returns <code>null</code>.
     *
     *  @return Principal The principal object.
     *
     *  @throws IllegalStateException This exception is thrown
     *          if the method is called while no request is
     *          being serviced.
     *
     *  @see java.security.Principal
     *  @see java.lang.IllegalStateException
     **/
    public Principal getUserPrincipal();
    
    /**
     *  Returns a boolean indicating whether the
     *  authenticated user is included in the specified
     *  logical role. If the user has not been
     *  authenticated, the method returns </code>false</code>.
     *
     *  @param role  A <code>String</code> specifying the name of the role
     *
     *  @return a <code>boolean</code> indicating whether
     *  the sender of the request belongs to a given role
     *
     *  @throws IllegalStateException This exception is thrown
     *          if the method is called while no request is
     *          being serviced.
     **/
    public boolean isUserInRole(String role);
    
    /**
     *  Returns the <code>W3CEndpointReference</code> for this
     *  endpoint.
     *  <p>
     *  The returned <code>EndpointReference</code> must contain
     *  the embedded WSDL in the <code>wsa:Metadata</code> element
     *  if there is an associated WSDL.
     *  It must also contain the <code>wsaw:InterfaceName</code>,
     *  <code>wsaw:ServiceName</code> elements and the <code>wsaw:EndpointName</code>
     *  attribute on the <code>wsaw:ServiceName</code>.
     *
     *  @return W3CEndpointReference of this instance.
     *
     *  @throws IllegalStateException This exception is thrown
     *          if the method is called while no request is
     *          being serviced.
     *
     * @since JAX-WS 2.1
     */
    public W3CEndpointReference getEndpointReference();

    /**
     *  Returns the <code>EndpointReference</code> associated with
     *  this endpoint.
     *  <p>
     *  The returned <code>EndpointReference</code> must contain
     *  the embedded WSDL in the <code>wsa:Metadata</code> element
     *  if the endpoint has a WSDL.
     *  It must also contain the <code>wsaw:InterfaceName</code>,
     *  <code>wsaw:ServiceName</code> elements and the <code>wsaw:EndpointName</code>
     *  attribute on the <code>wsaw:ServiceName</code>.
     *
     *  @return EndpointReference of type <code>clazz</code> of this instance.
     *
     *  @throws IllegalStateException This exception is thrown
     *          if the method is called while no request is
     *          being serviced.     
     *
     * @since JAX-WS 2.1
     **/
    public abstract <T extends EndpointReference> T getEndpointReference(Class<T> clazz);    
}
