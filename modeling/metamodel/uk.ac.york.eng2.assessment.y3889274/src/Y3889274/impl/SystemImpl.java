/**
 */
package Y3889274.impl;

import Y3889274.Domain;
import Y3889274.Event;
import Y3889274.EventStream;
import Y3889274.Microservice;
import Y3889274.Y3889274Package;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Y3889274.impl.SystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link Y3889274.impl.SystemImpl#getMicroservices <em>Microservices</em>}</li>
 *   <li>{@link Y3889274.impl.SystemImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link Y3889274.impl.SystemImpl#getEventStreams <em>Event Streams</em>}</li>
 *   <li>{@link Y3889274.impl.SystemImpl#getDomains <em>Domains</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends MinimalEObjectImpl.Container implements Y3889274.System {
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
	 * The cached value of the '{@link #getMicroservices() <em>Microservices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMicroservices()
	 * @generated
	 * @ordered
	 */
	protected EList<Microservice> microservices;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The cached value of the '{@link #getEventStreams() <em>Event Streams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventStreams()
	 * @generated
	 * @ordered
	 */
	protected EList<EventStream> eventStreams;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<Domain> domains;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Y3889274Package.Literals.SYSTEM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Y3889274Package.SYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Microservice> getMicroservices() {
		if (microservices == null) {
			microservices = new EObjectContainmentEList<Microservice>(Microservice.class, this, Y3889274Package.SYSTEM__MICROSERVICES);
		}
		return microservices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<Event>(Event.class, this, Y3889274Package.SYSTEM__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventStream> getEventStreams() {
		if (eventStreams == null) {
			eventStreams = new EObjectContainmentEList<EventStream>(EventStream.class, this, Y3889274Package.SYSTEM__EVENT_STREAMS);
		}
		return eventStreams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Domain> getDomains() {
		if (domains == null) {
			domains = new EObjectContainmentEList<Domain>(Domain.class, this, Y3889274Package.SYSTEM__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Y3889274Package.SYSTEM__MICROSERVICES:
				return ((InternalEList<?>)getMicroservices()).basicRemove(otherEnd, msgs);
			case Y3889274Package.SYSTEM__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case Y3889274Package.SYSTEM__EVENT_STREAMS:
				return ((InternalEList<?>)getEventStreams()).basicRemove(otherEnd, msgs);
			case Y3889274Package.SYSTEM__DOMAINS:
				return ((InternalEList<?>)getDomains()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Y3889274Package.SYSTEM__NAME:
				return getName();
			case Y3889274Package.SYSTEM__MICROSERVICES:
				return getMicroservices();
			case Y3889274Package.SYSTEM__EVENTS:
				return getEvents();
			case Y3889274Package.SYSTEM__EVENT_STREAMS:
				return getEventStreams();
			case Y3889274Package.SYSTEM__DOMAINS:
				return getDomains();
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
			case Y3889274Package.SYSTEM__NAME:
				setName((String)newValue);
				return;
			case Y3889274Package.SYSTEM__MICROSERVICES:
				getMicroservices().clear();
				getMicroservices().addAll((Collection<? extends Microservice>)newValue);
				return;
			case Y3889274Package.SYSTEM__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case Y3889274Package.SYSTEM__EVENT_STREAMS:
				getEventStreams().clear();
				getEventStreams().addAll((Collection<? extends EventStream>)newValue);
				return;
			case Y3889274Package.SYSTEM__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection<? extends Domain>)newValue);
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
			case Y3889274Package.SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Y3889274Package.SYSTEM__MICROSERVICES:
				getMicroservices().clear();
				return;
			case Y3889274Package.SYSTEM__EVENTS:
				getEvents().clear();
				return;
			case Y3889274Package.SYSTEM__EVENT_STREAMS:
				getEventStreams().clear();
				return;
			case Y3889274Package.SYSTEM__DOMAINS:
				getDomains().clear();
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
			case Y3889274Package.SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Y3889274Package.SYSTEM__MICROSERVICES:
				return microservices != null && !microservices.isEmpty();
			case Y3889274Package.SYSTEM__EVENTS:
				return events != null && !events.isEmpty();
			case Y3889274Package.SYSTEM__EVENT_STREAMS:
				return eventStreams != null && !eventStreams.isEmpty();
			case Y3889274Package.SYSTEM__DOMAINS:
				return domains != null && !domains.isEmpty();
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

} //SystemImpl
