/**
 */
package Y3889274;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Microservice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Y3889274.Microservice#getName <em>Name</em>}</li>
 *   <li>{@link Y3889274.Microservice#getEndpoints <em>Endpoints</em>}</li>
 * </ul>
 *
 * @see Y3889274.Y3889274Package#getMicroservice()
 * @model
 * @generated
 */
public interface Microservice extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Y3889274.Y3889274Package#getMicroservice_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Y3889274.Microservice#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link Y3889274.Endpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see Y3889274.Y3889274Package#getMicroservice_Endpoints()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Endpoint> getEndpoints();

} // Microservice
