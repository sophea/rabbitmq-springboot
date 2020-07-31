Ref : https://docs.google.com/document/d/1XaLllWUeXIKQU8j3mKDlZujFEmLr5ZMqLYupalCoPr8/edit?usp=sharing

Benefit using message queues
In modern cloud architecture, applications are decoupled into smaller  microservices, independent building blocks that are easier to develop, deploy and maintain. Message queues provide communication and coordination for these distributed applications.
Message queues can significantly simplify coding of decoupled applications, while improving performance, reliability and scalability. You can also combine message queues with Pub/Sub messaging in a fanout design pattern.  

Ref : https://stackify.com/message-queues-12-reasons/
1. Redundancy via Persistence
Redundancy is one of the most obvious advantages to message queues. Application crashes, timeouts, errors in your code, and other problems are just part of the norm. This is especially true in applications that process millions or billions of transactions per month.
Queues help with redundancy by making the process that reads the message confirm that it completed the transaction and it is safe to remove it. If anything fails, worst case scenario, the message is persisted to storage somewhere and won’t be lost. It can be reprocessed later.
 
2. Traffic Spikes
You don’t always know exactly how much traffic your application is going to have. For example, we receive billions of messages a month. We have no way to know what our clients are going to send us. By queuing the data we can be assured the data will be persisted and then be processed eventually, even if that means it takes a little longer than usual due to a high traffic spike.
 
3. Improve Web Application Page Load Times
Queues can be useful in web applications to do complex logic in a background thread so the request can finish for the user quickly. If someone places an order on your website, that could involve a lot of different things that have to happen. You can do the minimum and return success to your user and kick off the rest of them in a background thread to finish up, without using a full message queuing system and background apps. Most programming languages have ways to do this now.  
4. Batching for Efficiency
Batching is a great reason to use message queues. It is much more efficient to insert 100 records into a database at a time instead of 1 at a time, 100 times. We insert a lot of data into elasticsearch and SQL Server. Batching helps us optimize their performance by tuning the size of the transactions.
 
5. Asynchronous Messaging
Queues can be great in scenarios where your application needs something done but doesn’t need it done now, or doesn’t even care about the result. Instead of calling a web service and waiting for it to complete, you can write the message to a queue and let the same business logic happen later. Queues are an excellent way to implement an asynchronous programming pattern.
 
6. Decouple by Using Data Contracts
By using a queue between different parts of your software you can decouple the hard dependencies. The format of the message in the queue becomes your data contract and anything that knows how to read that message format can be used to process the transaction. This could be useful for parts of your code that are even written in different programming languages.
 
7. Transaction Ordering and Concurrency Challenges
If 1000 people are placing an order on your website at one time, that could create some problems with concurrency and ensuring that the first order-in finishes first. By queuing them up, you could then guarantee their order and control how many are even processed concurrently.
 
8. Improve Scalability
Message queues enable you to decouple different parts of your application and then scale them independently. Using Azure, AWS, or other hosting solutions you could even dynamically scale that background service based on CPU usage or other metrics. Message queues can help a lot with scalability and elasticity.
 
9. Create Resiliency
By breaking your app up and separating different components by queues, you inherently create more resiliency. Your website can still be operational even if part of the back end processing of the order is slightly delayed. At Stackify, we design our incoming APIs to do as little as possible beyond queuing the data to ensure that nothing else can bring down the ability to receive data. Even if SQL Server is down, we want to be able accept data!
 
 
10 Guarantee Transaction Occurs Once
Message queues are designed to be transactional. When you read a message off of a queue, you have to tell it where you completed processing the message before it is completely removed from the queue. This helps to ensure that a transaction only occurs once.
 
11 Break Larger Tasks into Many Smaller Ones
Another good use for queues is breaking up a larger task into lots of little pieces and then queuing them all up. We have a good example of this at Stackify. If you edit a monitoring template for a group of servers, we then need to update the monitors on every server that uses that template. We can queue up a message for every server and potentially do them concurrently as smaller operations.
 
12 Monitoring
Message queuing systems enable you to monitor how many items are in a queue, the rate of processing messages, and other stats. This can be very helpful from an application monitoring standpoint to keep an eye on how data is flowing through your system and if it is getting backed up.
