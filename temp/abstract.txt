# Blood Bank Management System (Java)

### Abstract

This project develops a simplified **Blood Bank Management System** in Java to manage donors, blood units, inventory, and transfusions. The system models key entities such as donors, recipients, staff, and inventory, and enforces basic blood-type compatibility rules with a FIFO (first-in, first-out) issuance policy. Initial deliverables include a UML class diagram, a concise design report, and a runnable console demo that demonstrates donor registration, inventory storage, compatibility checking, and issuance of compatible blood units. The system demonstrates principles of object-oriented design, modularity, and separation of concerns, and can be extended in the future with a graphical user interface, database integration, and advanced reporting features.

---

### 1. Introduction

Blood is a vital resource in healthcare, and managing donations and transfusions efficiently is critical. Manual systems for blood bank operations are error-prone, leading to risks such as issuing expired or incompatible blood. To solve this, a computerized system is proposed to manage donor records, inventory, and transfusion requests.

This project focuses on implementing a simplified **Blood Bank Management System** in Java. The design emphasizes modularity and scalability, allowing the prototype to evolve into a production-grade system.

---

### 2. Objectives

**Functional Objectives**

* Register donors and recipients.
* Record donations and generate blood units.
* Manage inventory (store, list, check expiry).
* Ensure compatibility when issuing blood.
* Issue blood units following FIFO rules.

**Non-Functional Objectives**

* Reliability: prevent expired or unsafe issuance.
* Extensibility: allow future upgrades (GUI, DB).
* Maintainability: clear object-oriented structure.

---

### 3. Scope

**Included:** donor registration, blood unit storage, compatibility checking, basic inventory operations, transfusion issuance.
**Excluded:** GUI interfaces, real database, test lab integrations, advanced medical reporting.

---

### 4. System Overview

The system models the workflow of a blood bank:

1. Donors provide blood → blood units are created.
2. Units are stored in the inventory.
3. Recipients request blood.
4. The system checks compatibility and availability.
5. Compatible units are issued.

The design follows OOP principles with dedicated classes for Donor, Recipient, BloodUnit, Inventory, and Staff.

---

### 5. UML Design

!\[Class Diagram]\(upload this PlantUML source at [https://plantuml.com/plantuml/uml/](https://plantuml.com/plantuml/uml/))

```plantuml
@startuml
class Donor {
  - String id
  - String name
  - String dob
  - BloodType bloodType
  - String contact
  + BloodUnit donate()
}

class Recipient {
  - String id
  - String name
  - BloodType bloodType
  - String contact
  + requestTransfusion()
}

class BloodUnit {
  - String id
  - BloodType type
  - LocalDate collectionDate
  - LocalDate expiryDate
  - Status status
  - String donorId
  + boolean isExpired()
  + void markIssued()
}

class Inventory {
  - List<BloodUnit> units
  + void addUnit(BloodUnit)
  + BloodUnit findCompatible(BloodType)
  + boolean issueUnit(BloodUnit, Recipient)
  + List<BloodUnit> listAvailable()
}

class Staff {
  - String id
  - String name
  - String role
  + acceptDonation(BloodUnit)
  + performIssue(BloodUnit, Recipient)
  + runInventoryReport()
}

enum BloodType
enum Status

Donor "1" -- "0..*" BloodUnit : "donates >"
Inventory "1" o-- "0..*" BloodUnit : "stores >"
Staff --> Inventory : "manages"
Recipient "0..*" -- "0..*" BloodUnit : "receives >"
BloodUnit --> BloodType
BloodUnit --> Status
@enduml
```

---

### 6. Key Algorithms

* **Compatibility Check:** ABO & Rh rules determine donor–recipient matching.
* **Expiry Handling:** expired units are excluded from availability.
* **FIFO Issuance:** units issued in order of collection date.

---

### 7. Implementation Details

* **Language:** Java 8+

* **Project Structure:**

  * `Donor.java`
  * `Recipient.java`
  * `BloodUnit.java`
  * `Inventory.java`
  * `Staff.java`
  * `BloodType.java`, `Status.java`
  * `MainDemo.java`

* **How to Run:**

  ```bash
  javac *.java
  java MainDemo
  ```

---

### 8. Testing Plan

* **Unit tests:** isExpired(), compatibility()
* **Manual tests:** donation, expired unit removal, incompatible transfusion attempt, inventory after issuance

---

### 9. Conclusion & Future Work

The prototype demonstrates core functionality of a blood bank system using OOP in Java. Future improvements include:

* Database integration for persistence
* Web or desktop GUI
* Authentication and access control
* Automated expiry removal
* Advanced analytics and reporting

---

### References

* Java Documentation (Oracle)
* UML Class Diagram Notation Guide
* Blood Transfusion Compatibility Guidelines (WHO)
