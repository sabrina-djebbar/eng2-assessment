/**
 */
package Y3889274;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Stream</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Y3889274.EventStream#getName <em>Name</em>}</li>
 *   <li>{@link Y3889274.EventStream#getEvent <em>Event</em>}</li>
 *   <li>{@link Y3889274.EventStream#getSubscriber <em>Subscriber</em>}</li>
 *   <li>{@link Y3889274.EventStream#getPublisher <em>Publisher</em>}</li>
 * </ul>
 *
 * @see Y3889274.Y3889274Package#getEventStream()
 * @model
 * @generated
 */
public interface EventStream extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Y3889274.Y3889274Package#getEventStream_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Y3889274.EventStream#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(Event)
	 * @see Y3889274.Y3889274Package#getEventStream_Event()
	 * @model
	 * @generated
	 */
	Event getEvent();

	/**
	 * Sets the value of the '{@link Y3889274.EventStream#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Subscriber</b></em>' reference list.
	 * The list contents are of type {@link Y3889274.Microservice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscriber</em>' reference list.
	 * @see Y3889274.Y3889274Package#getEventStream_Subscriber()
	 * @model
	 * @generated
	 */
	EList<Microservice> getSubscriber();

	/**
	 * Returns the value of the '<em><b>Publisher</b></em>' reference list.
	 * The list contents are of type {@link Y3889274.Microservice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publisher</em>' reference list.
	 * @see Y3889274.Y3889274Package#getEventStream_Publisher()
	 * @model
	 * @generated
	 */
	EList<Microservice> getPublisher();

} // EventStream
