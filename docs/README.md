# Anna User Guide

Anna is a simple chatbot that helps you manage your tasks.  
You can add todos, deadlines, and events, list them, mark/unmark them as done, delete tasks, and find tasks by keyword.  
All tasks are saved automatically in `data/anna.txt`.


## Adding deadlines

Adds a task with a description and a due date.  
Useful for keeping track of tasks that need to be completed before a specific date/time.

Example:
deadline return book /by Sunday
```
expected output
Got it. I’ve added this task:
[D][ ] return book (by: Sunday)
Now you have 1 task in the list.
```

## Adding Todos

Adds a task without any date/time attached.  
Use this when you just want to record a simple task to do.

Example:
todo read book

```
expected output
Got it. I’ve added this task:
[T][ ] read book
Now you have 2 tasks in the list.
```

## Adding events

Adds a task that has both a start and end time.  
Useful for scheduling events with a duration.

Example:
event project meeting /from Monday 2pm /to Monday 4pm

```
expected output
Got it. I’ve added this task:
[E][ ] project meeting (from: Monday 2pm to: Monday 4pm)
Now you have 3 tasks in the list.
```

---

## Listing all tasks

Displays all tasks currently stored in the list, numbered for reference.

Example:
list

```
expected output
1.[D][ ] return book (by: Sunday)
2.[T][ ] read book
3.[E][ ] project meeting (from: Monday 2pm to: Monday 4pm)
```

---

## Marking a task as done

Marks a task at the given index as completed.

Example:
mark 2

```
expected output
Nice! I’ve marked this task as done:
[T][X] read book
```

---

## Unmarking a task

Marks a task at the given index as not completed yet.

Example:
unmark 2

```
expected output
Nice! I’ve marked this task as not done yet:
[T][ ] read book
```


---

## Deleting a task

Removes a task at the given index from the list.

Example:
delete 2

```
expected output
Noted. I’ve removed this task:
[D][ ] return book (by: Sunday)
Now you have 2 tasks in the list.
```

---

## Finding tasks by keyword

Searches all tasks for a given keyword and shows matching tasks.

Example:
find book

```
expected output
Here are the matching tasks in your list:
1.[T][ ] read book
```


---

## Exiting Anna

Ends the program. Tasks are saved automatically before exit.

Example:
bye

```
expected output
Bye. Hope to see you again soon!
```