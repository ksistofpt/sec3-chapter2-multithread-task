<h1>Task Description</h1>

<p>
        Imagine you are designing a traffic light controller for a busy intersection. The traffic light system consists of three stages: <strong>red light</strong>, <strong>yellow light</strong>, and <strong>green light</strong>. These stages must be executed in a specific order to ensure safe and efficient traffic flow.
    </p>
    <p>
        Your task is to implement the methods: <code>redLight()</code>, <strongcode>yellowLight()</code>, and <code>greenLight()</code>. These methods must be executed strictly in the order of a real traffic light: first red light, then yellow light, and finally green light, regardless of the order in which threads call them.
    </p>

<h2>Requirements:</h2>
<ol>
    <li><strong>Synchronization:</strong> Ensure that methods are executed in strict order.</li>
    <li><strong>Multithreading:</strong> Methods can be called from different threads, but execution must occur in the order: <code>method1</code>, <code>method2</code>, <code>greenLight()</code>.</li>
    <li><strong>Use Lock and Condition:</strong> Apply Lock to control access to shared resources and Condition to coordinate threads.</li>
</ol>

<p><strong>Hint:</strong></p>
<p>The counter field in the <code>TaskLockExample</code> class is specified for a reason; you will need to check its value in each method and depending on what is there you decide whether to start this thread or not.</p>

<p>You also need to use the <code>lock</code> and <code>condition</code> fields to lock some thread and decide who will be first, second, and third.</p>
