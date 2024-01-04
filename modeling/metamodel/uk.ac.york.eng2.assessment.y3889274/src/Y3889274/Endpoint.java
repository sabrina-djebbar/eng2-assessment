/**
 */
package Y3889274;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Y3889274.Endpoint#getName <em>Name</em>}</li>
 *   <li>{@link Y3889274.Endpoint#getMethod <em>Method</em>}</li>
 *   <li>{@link Y3889274.Endpoint#getRequest <em>Request</em>}</li>
 *   <li>{@link Y3889274.Endpoint#getResponse <em>Response</em>}</li>
 * </ul>
 *
 * @see Y3889274.Y3889274Package#getEndpoint()
 * @model
 * @generated
 */
public interface Endpoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Y3889274.Y3889274Package#getEndpoint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Y3889274.Endpoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * The literals are from the enumeration {@link Y3889274.HTTPMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see Y3889274.HTTPMethod
	 * @see #setMethod(HTTPMethod)
	 * @see Y3889274.Y3889274Package#getEndpoint_Method()
	 * @model
	 * @generated
	 */
	HTTPMethod getMethod();

	/**
	 * Sets the value of the '{@link Y3889274.Endpoint#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see Y3889274.HTTPMethod
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(HTTPMethod value);

	/**
	 * Returns the value of the '<em><b>Request</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Request</em>' containment reference.
	 * @see #setRequest(Request)
	 * @see Y3889274.Y3889274Package#getEndpoint_Request()
	 * @model containment="true"
	 * @generated
	 */
	Request getRequest();

	/**
	 * Sets the value of the '{@link Y3889274.Endpoint#getRequest <em>Request</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request</em>' containment reference.
	 * @see #getRequest()
	 * @generated
	 */
	void setRequest(Request value);

	/**
	 * Returns the value of the '<em><b>Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response</em>' containment reference.
	 * @see #setResponse(Response)
	 * @see Y3889274.Y3889274Package#getEndpoint_Response()
	 * @model containment="true"
	 * @generated
	 */
	Response getResponse();

	/**
	 * Sets the value of the '{@link Y3889274.Endpoint#getResponse <em>Response</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response</em>' containment reference.
	 * @see #getResponse()
	 * @generated
	 */
	void setResponse(Response value);

} // Endpoint
