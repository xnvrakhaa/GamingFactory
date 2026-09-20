Project Description

This project demonstrates two creational design patterns in Java:

Factory Method
Abstract Factory

The project is based on a gaming setup with GPUs and monitors.

The Factory Method is used to create different GPU products.

The Abstract Factory is used to create families of related gaming products, such as a GPU and a monitor.

Factory Method

The Factory Method part contains:

GPU — Product interface.
NvidiaGPU — Concrete Product.
AMDGPU — Concrete Product.
GPUCreator — Creator that declares the factory method.
NvidiaGPUCreator — Concrete Creator for NVIDIA GPU.
AMDGPUCreator — Concrete Creator for AMD GPU.

The createGPU() method is the Factory Method.

It allows different creators to decide which concrete GPU should be created.

Abstract Factory

The Abstract Factory part contains:

GPU — Abstract Product for GPUs.
Monitor — Abstract Product for monitors.
NvidiaGPU and NvidiaMonitor — NVIDIA product family.
AMDGPU and AMDMonitor — AMD product family.
GamingFactory — Abstract Factory.
NvidiaGamingFactory — Concrete Factory for NVIDIA products.
AMDGamingFactory — Concrete Factory for AMD products.
Main — Client.

Each concrete factory creates a consistent family of related products.

For example, NvidiaGamingFactory creates an NVIDIA GPU and an NVIDIA monitor.

The client works through the GamingFactory, GPU, and Monitor interfaces instead of directly creating concrete products.

Difference Between the Patterns

Factory Method is used to create one type of product.

In this project, it creates different types of GPUs.

Abstract Factory is used to create a family of related products.

In this project, it creates a GPU and a monitor belonging to the same family.

Clean Code Principles
1. Meaningful Names

Methods and classes have clear names such as createGPU(), createMonitor(), NvidiaGPU, and AMDGamingFactory.

These names clearly describe their purpose.

2. Small Methods

Methods such as createGPU(), createMonitor(), and showInfo() perform one clear task.

This makes the code easier to understand and maintain.

3. Focused Classes

Each class has a specific responsibility.

Product classes represent products, creator classes create products, factory classes create product families, and Main acts as the client.

4. No Magic Numbers

Important numeric values should be represented using meaningful named constants instead of unexplained numbers.

For example, using HIGH_END_RAM is clearer than directly using a number such as 64.

5. Separation of Responsibilities

The client does not directly create concrete products.

Instead, it uses the abstract factory and product interfaces.

This reduces dependencies between the client and concrete product classes.

Project Structure

The project contains separate classes for:

GPU products
Monitor products
Factory Method creators
Abstract Factory
Concrete factories
Client

This separation makes the project easier to understand and maintain.

How to Run

Open the project in IntelliJ IDEA.

Open Main.java.

Run the main() method.

The program creates NVIDIA and AMD gaming setups and displays information about their GPUs and monitors.

Conclusion

This project demonstrates how Factory Method and Abstract Factory can be used to organize object creation.

Factory Method provides a way to create different GPU products.

Abstract Factory provides a way to create consistent families of gaming products.

The project also applies Clean Code principles to improve readability and maintainability.