# Handong Univ Graduation Requirement Checker 

## Team Members
22201044 이시현

## Presentation Video
([https://youtu.be/YZB3UAXCAuI])

## Project Description
This project is a Java-based console application designed to help university students easily check their graduation status. 
When a student inputs their earned credits (such as major, liberal arts, and design credits), the program reads the specific graduation requirements for their department from an external CSV file. 
Utilizing object-oriented programming (OOP) logic, the application then compares the student's data against these departmental standards to calculate any missing credits and intuitively displays the final evaluation result (Pass/Fail).

## UML Diagram of Classes and Interfaces

<img width="1049" height="693" alt="uml_diagram" src="https://github.com/user-attachments/assets/67bf3b89-1dc6-41cf-bf6e-ae1474b7080c" />


## User's Guide
### 1. Program Start & Requirement Check
<img width="450" height="500" alt="이미지 2026  4  21  오전 6 14" src="https://github.com/user-attachments/assets/510dd742-bc31-4636-81d1-af4d05909a1d" />

<img width="450" height="500" alt="이미지 2026  4  21  오전 6 14 (1)" src="https://github.com/user-attachments/assets/e361a31a-2e7e-4e64-9f6b-38a045df4d2d" />



* When you run the program, the main menu will appear. Press `1` to input the student's name, department, current earned credits, and English level in sequence.
* After passing the validation check, the program calculates and displays the deficient credits and the minimum number of remaining semesters required for graduation.

### 2. Administer Mode (Adding a New Department)
* Press `2` from the menu and enter the security password (`1234`) to access the Admin mode.
* Once you input the graduation criteria for a new department, the data is automatically added to the `graduation_rules.csv` file and reflected in the program in real-time.

<img width="400" height="420" alt="이미지 2026  4  21  오전 6 37" src="https://github.com/user-attachments/assets/3f9c2f39-a745-4d2d-95af-e0b6b6eb3163" />

<img width="400" height="420" alt="이미지 2026  4  21  오전 6 37" src="https://github.com/user-attachments/assets/95d959fe-372e-4799-8cdc-a2f38de92b97" />



### 3. Data Validation & Error Handling
* The program includes robust validation logic to prevent illogical inputs. 
* For example, if a user enters major or liberal arts credits that exceed the total earned credits, it immediately displays an error message and stops the process to ensure accurate calculation.

<img width="450" height="500" alt="이미지 2026  4  21  오전 6 43" src="https://github.com/user-attachments/assets/c8000f2a-7c32-4109-bbf5-72e55ead38e9" />


### How to Run
* Environment: Java 8 or higher.
* Execution: Run the `GraduationMain.java` file in your IDE (e.g., Eclipse) console.
* Important: The `graduation_rules.csv` file MUST be located in the same root directory as the project for the program to successfully load the department list via File I/O.


