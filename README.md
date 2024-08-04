<h1>Task Description</h1>

<p>You need to create a class with three methods: <code>method1</code>, <code>method2</code>, and <code>method3</code> (already implemented in the assignment). These methods must be executed strictly in a given order, regardless of the order of threads that call them. That is, <code>method1</code> should always be executed first, then <code>method2</code>, and only after that <code>method3</code>.</p>

<h2>Requirements:</h2>
<ol>
    <li><strong>Synchronization:</strong> Ensure that methods are executed in strict order.</li>
    <li><strong>Multithreading:</strong> Methods can be called from different threads, but execution must occur in the order: <code>method1</code>, <code>method2</code>, <code>method3</code>.</li>
    <li><strong>Use Lock and Condition:</strong> Apply Lock to control access to shared resources and Condition to coordinate threads.</li>
</ol>

<p><strong>Hint:</strong></p>
<p>The counter field in the <code>TaskLockExample</code> class is specified for a reason; you will need to check its value in each method and depending on what is there you decide whether to start this thread or not.</p>

<p>You also need to use the <code>lock</code> and <code>condition</code> fields to lock some thread and decide who will be first, second, and third.</p>
