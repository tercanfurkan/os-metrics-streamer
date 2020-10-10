- Status: draft

# OS Metric Streamer

## Summary

Stream OS metrics to the database using events

## Motivation

Use latest java version and APIs as possible to get the OS system metrics, 
for the event producer and consumer.

Pass the metrics to a PostgreSQL database using events, to practice event
streaming using Kafka producer/broker/consumer components.

## Detailed design

Implement a system that generates operating system metrics and
pass the events through Aiven Kafka instance to Aiven PostgreSQL database.
For this, use a Kafka producer which sends data to a Kafka topic, and a
Kafka consumer storing the data to Aiven PostgreSQL database. For practical
reasons, these components may run in the same machine (or container or whatever
system), but in production use similar components that would run in
different systems.

Choose whatever metric or metrics to collect and send. Implement
metrics collection by yourself or use any available tools or libraries.

Aiven is a Database as a Service vendor and the solution requires using Aiven
services. Register to Aiven at https://console.aiven.io/signup.html at
which point you'll automatically be given $300 worth of credits to play around
with. The credits should be enough for a few hours of use of our services. 
Contact Aiven if more credits are needed.

## Testing & packaging

It should include tests and proper packaging. If the tests require Kafka and 
PostgreSQL services, for simplicity tests can assume those are already 
running, instead of integrating Aiven service creation and deleting.

## Other quality requirements

- Code formatting and clarity. Readable code written for other
developers is valuable, not for a tutorial, or as one-off hack.
- Demonstrating experience and knowledge appreciated, but also utilizing
existing libraries. There is no need to re-invent the wheel.
- Practicality of testing. 100% test coverage may not be practical, and also
having 100% coverage but no validation is not very useful.
- Automation. Things should work automatically, instead of multi-step
instructions to run misc commands to set up things. Similarly, CI is a
relevant thing for automation.
- Attribution. If you take code from Google results, examples etc., add
attributions. We all know new things are often written based on search results.
- "Open source ready" repository. It's very often a good idea to pretend the
homework assignment in Github is used by random people.
