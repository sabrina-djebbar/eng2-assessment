/**
 */
package Y3889274;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Y3889274.Field#getName <em>Name</em>}</li>
 *   <li>{@link Y3889274.Field#getType <em>Type</em>}</li>
 *   <li>{@link Y3889274.Field#getObjectType <em>Object Type</em>}</li>
 * </ul>
 *
 * @see Y3889274.Y3889274Package#getField()
 * @model
 * @generated
 */
public interface Field extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Y3889274.Y3889274Package#getField_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Y3889274.Field#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see Y3889274.Y3889274Package#getField_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link Y3889274.Field#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Object Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Type</em>' reference.
	 * @see #setObjectType(Domain)
	 * @see Y3889274.Y3889274Package#getField_ObjectType()
	 * @model
	 * @generated
	 */
	Domain getObjectType();

	/**
	 * Sets the value of the '{@link Y3889274.Field#getObjectType <em>Object Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Type</em>' reference.
	 * @see #getObjectType()
	 * @generated
	 */
	void setObjectType(Domain value);

} // Field
