#  Gaming Factory

A Java project demonstrating two **Creational Design Patterns**:

-  **Factory Method**
-  **Abstract Factory**

The project uses a gaming setup domain with **GPUs** and **Monitors** to demonstrate object creation, product families, and separation between client code and concrete implementations.

---

##  Project Overview

The main goal of this project is to demonstrate how creational design patterns separate **object creation** from **client code**.

###  Factory Method

Used to create different types of GPUs.
 Abstract Factory

Used to create families of related gaming products:

- GPU
- Monitor

Two product families are implemented:

- 🟢 NVIDIA
- 🔴 AMD

---

#  Factory Method

The **Factory Method** is a creational design pattern that provides a method for creating objects while allowing subclasses to decide which concrete object should be created.

In this project, the Factory Method is used to create different GPU implementations.

## Components

| Component | Class | Role |
|---|---|---|
| Product | `GPU` | Common interface for all GPUs |
| Concrete Product | `NvidiaGPU` | NVIDIA GPU implementation |
| Concrete Product | `AMDGPU` | AMD GPU implementation |
| Creator | `GPUCreator` | Declares the Factory Method |
| Concrete Creator | `NvidiaGPUCreator` | Creates `NvidiaGPU` |
| Concrete Creator | `AMDGPUCreator` | Creates `AMDGPU` |

## Structure

```text
                 GPUCreator
                     │
              createGPU()
                     │
          ┌──────────┴──────────┐
          ↓                     ↓
 NvidiaGPUCreator        AMDGPUCreator
          │                     │
          ↓                     ↓
     NvidiaGPU               AMDGPU
```

The `createGPU()` method is the **Factory Method**.

Each concrete creator decides which GPU implementation should be created:

- `NvidiaGPUCreator` → `NvidiaGPU`
- `AMDGPUCreator` → `AMDGPU`

The creator works with the common `GPU` interface instead of depending on one specific GPU implementation.

---

# 🏗 Abstract Factory

The **Abstract Factory** is a creational design pattern used to create families of related objects without specifying their concrete classes in the client code.

In this project, each factory creates a complete gaming product family consisting of:

- GPU
- Monitor

## Abstract Products

The project has two abstract product interfaces:

- `GPU`
- `Monitor`

## NVIDIA Family

```text
          NvidiaGamingFactory
                  │
             ┌────┴────┐
             ↓         ↓
        NvidiaGPU  NvidiaMonitor
```

## AMD Family

```text
           AMDGamingFactory
                  │
             ┌────┴────┐
             ↓         ↓
          AMDGPU   AMDMonitor
```

## Components

| Component | Class | Role |
|---|---|---|
| Abstract Product | `GPU` | GPU interface |
| Abstract Product | `Monitor` | Monitor interface |
| Concrete Product | `NvidiaGPU` | NVIDIA GPU |
| Concrete Product | `NvidiaMonitor` | NVIDIA monitor |
| Concrete Product | `AMDGPU` | AMD GPU |
| Concrete Product | `AMDMonitor` | AMD monitor |
| Abstract Factory | `GamingFactory` | Creates a product family |
| Concrete Factory | `NvidiaGamingFactory` | Creates NVIDIA products |
| Concrete Factory | `AMDGamingFactory` | Creates AMD products |
| Client | `Main` | Uses the abstract factory |

---

#  How Abstract Factory Works

The client works only with abstract interfaces:

```text
                     GamingFactory
                    /              \
                   /                \
                  ↓                  ↓
      NvidiaGamingFactory      AMDGamingFactory
              │                       │
        ┌─────┴─────┐           ┌─────┴─────┐
        ↓           ↓           ↓           ↓
   NvidiaGPU  NvidiaMonitor  AMDGPU    AMDMonitor
```

For example:

```java
GamingFactory nvidiaFactory = new NvidiaGamingFactory();

GPU gpu = nvidiaFactory.createGPU();
Monitor monitor = nvidiaFactory.createMonitor();
```

The client does not directly create concrete products.

Instead, object creation is delegated to the concrete factory.

This keeps the client independent from concrete product classes.

---

#  Factory Method vs Abstract Factory

| Factory Method | Abstract Factory |
|---|---|
| Creates one type of product | Creates a family of related products |
| Creates GPUs | Creates GPUs and monitors |
| Uses `GPUCreator` | Uses `GamingFactory` |
| Concrete creators decide which GPU to create | Concrete factories create a consistent product family |
| Example: NVIDIA GPU | Example: NVIDIA GPU + NVIDIA Monitor |

### Main Difference

**Factory Method** focuses on creating **one product**.

**Abstract Factory** focuses on creating **multiple related products that belong to the same family**.

```text
Factory Method
      │
      └── GPU
```

```text
Abstract Factory
      │
      ├── GPU
      └── Monitor
```

---

# 🧹 Clean Code Principles

The project applies several Clean Code principles.

## 1. Meaningful Names

Classes and methods use names that clearly describe their purpose.

Examples:

```text
createGPU()
createMonitor()
NvidiaGamingFactory
AMDGamingFactory
```

Meaningful names make the code easier to understand.

---

## 2. Small Methods

Methods perform one clear task.

Example:

```java
public GPU createGPU() {
    return new NvidiaGPU();
}
```

The method only creates and returns a GPU.

Small methods are easier to understand and maintain.

---

## 3. Focused Classes

Each class has a specific responsibility.

| Class Type | Responsibility |
|---|---|
| Product classes | Represent products |
| Creator classes | Create individual products |
| Factory classes | Create product families |
| `Main` | Acts as the client |

This keeps the project organized and easier to maintain.

---

## 4. No Magic Numbers or Strings

The code avoids unnecessary unexplained values.

Instead of:

```java
if (ram > 64) {
    ...
}
```

a meaningful constant can be used:

```java
private static final int HIGH_END_RAM = 64;
```

Named values make the code easier to understand and modify.

---

## 5. Separation of Responsibilities

The client does not directly create concrete products.

The `Main` class works through:

- `GamingFactory`
- `GPU`
- `Monitor`

Example:

```java
GamingFactory factory = new NvidiaGamingFactory();

GPU gpu = factory.createGPU();
Monitor monitor = factory.createMonitor();
```

This reduces the dependency between the client and concrete product classes.

---

#  Project Structure

```text
GamingFactory/
│
├── src/
│   ├── GPU.java
│   ├── NvidiaGPU.java
│   ├── AMDGPU.java
│   │
│   ├── GPUCreator.java
│   ├── NvidiaGPUCreator.java
│   ├── AMDGPUCreator.java
│   │
│   ├── Monitor.java
│   ├── NvidiaMonitor.java
│   ├── AMDMonitor.java
│   │
│   ├── GamingFactory.java
│   ├── NvidiaGamingFactory.java
│   ├── AMDGamingFactory.java
│   │
│   └── Main.java
│
└── README.md
```

---

#  How to Run

1. Open the project in **IntelliJ IDEA**.
2. Open `Main.java`.
3. Run the `main()` method.
4. The program creates NVIDIA and AMD gaming setups.
5. The created products are displayed in the console.

---

#  Example Output

```text
=== NVIDIA Gaming Setup ===
NVIDIA GeForce RTX 4070
NVIDIA G-SYNC Gaming Monitor

=== AMD Gaming Setup ===
AMD Radeon RX 7900 XTX
AMD FreeSync Gaming Monitor
```

---



