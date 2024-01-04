/**
 */
package Y3889274;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Y3889274.Response#getName <em>Name</em>}</li>
 *   <li>{@link Y3889274.Response#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link Y3889274.Response#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see Y3889274.Y3889274Package#getResponse()
 * @model
 * @generated
 */
public interface Response extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Y3889274.Y3889274Package#getResponse_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Y3889274.Response#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Code</em>' attribute.
	 * @see #setStatusCode(String)
	 * @see Y3889274.Y3889274Package#getResponse_StatusCode()
	 * @model
	 * @generated
	 */
	String getStatusCode();

	/**
	 * Sets the value of the '{@link Y3889274.Response#getStatusCode <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Code</em>' attribute.
	 * @see #getStatusCode()
	 * @generated
	 */
	void setStatusCode(String value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference list.
	 * The list contents are of type {@link Y3889274.Field}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference list.
	 * @see Y3889274.Y3889274Package#getResponse_Body()
	 * @model containment="true"
	 * @generated
	 */
	EList<Field> getBody();

} // Response
