/**
 */
package Y3889274.impl;

import Y3889274.Event;
import Y3889274.EventStream;
import Y3889274.Microservice;
import Y3889274.Y3889274Package;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Stream</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Y3889274.impl.EventStreamImpl#getName <em>Name</em>}</li>
 *   <li>{@link Y3889274.impl.EventStreamImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link Y3889274.impl.EventStreamImpl#getSubscriber <em>Subscriber</em>}</li>
 *   <li>{@link Y3889274.impl.EventStreamImpl#getPublisher <em>Publisher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventStreamImpl extends MinimalEObjectImpl.Container implements EventStream {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected Event event;

	/**
	 * The cached value of the '{@link #getSubscriber() <em>Subscriber</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscriber()
	 * @generated
	 * @ordered
	 */
	protected EList<Microservice> subscriber;

	/**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected EList<Microservice> publisher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventStreamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Y3889274Package.Literals.EVENT_STREAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Y3889274Package.EVENT_STREAM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getEvent() {
		if (event != null && event.eIsProxy()) {
			InternalEObject oldEvent = (InternalEObject)event;
			event = (Event)eResolveProxy(oldEvent);
			if (event != oldEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Y3889274Package.EVENT_STREAM__EVENT, oldEvent, event));
			}
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(Event newEvent) {
		Event oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Y3889274Package.EVENT_STREAM__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Microservice> getSubscriber() {
		if (subscriber == null) {
			subscriber = new EObjectResolvingEList<Microservice>(Microservice.class, this, Y3889274Package.EVENT_STREAM__SUBSCRIBER);
		}
		return subscriber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Microservice> getPublisher() {
		if (publisher == null) {
			publisher = new EObjectResolvingEList<Microservice>(Microservice.class, this, Y3889274Package.EVENT_STREAM__PUBLISHER);
		}
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Y3889274Package.EVENT_STREAM__NAME:
				return getName();
			case Y3889274Package.EVENT_STREAM__EVENT:
				if (resolve) return getEvent();
				return basicGetEvent();
			case Y3889274Package.EVENT_STREAM__SUBSCRIBER:
				return getSubscriber();
			case Y3889274Package.EVENT_STREAM__PUBLISHER:
				return getPublisher();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Y3889274Package.EVENT_STREAM__NAME:
				setName((String)newValue);
				return;
			case Y3889274Package.EVENT_STREAM__EVENT:
				setEvent((Event)newValue);
				return;
			case Y3889274Package.EVENT_STREAM__SUBSCRIBER:
				getSubscriber().clear();
				getSubscriber().addAll((Collection<? extends Microservice>)newValue);
				return;
			case Y3889274Package.EVENT_STREAM__PUBLISHER:
				getPublisher().clear();
				getPublisher().addAll((Collection<? extends Microservice>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Y3889274Package.EVENT_STREAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Y3889274Package.EVENT_STREAM__EVENT:
				setEvent((Event)null);
				return;
			case Y3889274Package.EVENT_STREAM__SUBSCRIBER:
				getSubscriber().clear();
				return;
			case Y3889274Package.EVENT_STREAM__PUBLISHER:
				getPublisher().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Y3889274Package.EVENT_STREAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Y3889274Package.EVENT_STREAM__EVENT:
				return event != null;
			case Y3889274Package.EVENT_STREAM__SUBSCRIBER:
				return subscriber != null && !subscriber.isEmpty();
			case Y3889274Package.EVENT_STREAM__PUBLISHER:
				return publisher != null && !publisher.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EventStreamImpl
