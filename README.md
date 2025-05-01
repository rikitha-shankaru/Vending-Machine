# ☕ Vending Machine Project

**Course**: CS 586 - Software Systems Architecture  
**Semester**: Spring 2025  
**Student**: Likitha Shankar  

---

## 🧾 Project Overview

This project implements two components—**VM-1** and **VM-2**—of a Vending Machine system using **Model-Driven Architecture (MDA)** and an **Extended Finite State Machine (EFSM)** model.

The goal is to:
- Design MDA-EFSM-based vending machines using object-oriented principles.
- Apply three core OO design patterns:
  - ✅ **State Pattern**
  - ✅ **Strategy Pattern**
  - ✅ **Abstract Factory Pattern**
- Ensure **low coupling** and **high cohesion** between components.
- Provide both **static (class diagrams)** and **dynamic (sequence diagrams)** designs.
- Implement a testable and extensible driver-based simulation.

---

## 🗂 Project Structure

VendingMachine/
├── src/
│   ├── AbstractFactory/       # Abstract + Concrete factories for VM1 & VM2
│   ├── DataStore/             # Abstract and concrete data storage classes
│   ├── Driver/                # Driver class to run VM
│   ├── InputProcessor/        # VM1.java and VM2.java (command handlers)
│   ├── MDAEFSM/               # Main FSM controller & State pattern core
│   │   └── StatePattern/            # All individual state classes
│   ├── OutputProcessor/       # Executes actions from state transitions
│       └── StrategyPattern/       # Strategy interfaces and implementations
├── bin/                       # Compiled output directory
├── manifest.txt               # Manifest for JAR execution
├── VendingMachine.jar         # Executable JAR
├── README.md                  # This file

---

## ⚙️ Compilation Instructions

Make sure Java JDK 11 or later is installed.

In your terminal:

# Compile source files
javac -d bin $(find src -name "*.java")

# Package into JAR
jar cfm VendingMachine.jar manifest.txt -C bin .

---

## ▶️ How to Run

java -jar VendingMachine.jar

You’ll be prompted to choose:
- `1` → VM-1: Supports sugar, cappuccino, chocolate
- `2` → VM-2: Supports coffee, sugar, cream

Then, follow the prompts to perform operations like inserting cups, making payments, and choosing additives/drinks.

Note: These sequences represent logical operations. Each operation is selected step-by-step through the interactive console.

---

## 🔬 Sample Test Scenarios

### 📌 Scenario 1 — VM-1 (Card Payment, Cappuccino)

create(2.5)
insert_cups(20)
card(7.2)
sugar()
cappuccino()

### 📌 Scenario 2 — VM-2 (Coins, Coffee + Cream)

CREATE(2)
InsertCups(1)
COIN(1)
COIN(1)
CREAM()
COFFEE()

---

## 🧩 Design Patterns Used

### 🔄 State Pattern
- Implemented under `MDAEFSM/StatePattern/`
- Each state class (e.g., `Idle`, `Start`, `NoCups`, `Coins_Inserted`) implements behaviors differently.
- EFSM logic orchestrated by `MDAEFSM.java`, which delegates behavior to current state.

### 🎭 Strategy Pattern
- Implemented under `OutputProcessor/StrategyPattern/`
- Used for dynamic operations like `StorePrice`, `ReturnCoins`, `IncreaseCF`, `DisposeDrink`, etc.
- Selected at runtime by the OutputProcessor.

### 🏭 Abstract Factory Pattern
- Implemented in `AbstractFactory/`
- Factory classes (`VM1Factory`, `VM2Factory`) create:
  - Platform-dependent `DataStore` objects
  - Matching implementations for strategies

---

## ✅ Notes

- **Cohesion and Coupling**: Each component/module is highly cohesive and loosely coupled.
- **Commenting**: Every file contains clear comments, especially for design pattern implementation.
- **Testing**: All required user scenarios and transitions have been tested via the driver.

---

## 📧 Contact
 
**Likitha Shankar**  
📧 [lshankar@hawk.iit.edu](mailto:lshankar@hawk.iit.edu)


For any issues or clarifications related to the project.