# Cross The Streams - SpringOne 2020

## :wave: Getting Started
The following tools will be helpful to hack on the project:
1. [SDKMAN! (JDK version manager)](https://sdkman.io/install)
1. [kind (quickly setup a local Kubernetes cluster)](https://kind.sigs.k8s.io/docs/user/quick-start/)
1. [JMeter (performance testing harness)](https://jmeter.apache.org/download_jmeter.cgi)

## Repository Layout
This repository has two branches:
1. `main` - this branch is the starting point for the coding demo
1. `graceful-shutdown-support` - this branch contains the changes made to the codebase to support graceful shutdowns during the demo

## Deploying The Application
1. Install Java 11
    ```bash
    sdk install java 11.0.2-open
    ```
1. Create a Kubernetes cluster with kind
    ```bash
    kind create cluster --config kind.config.yaml
    ```

1. Build the Docker image:
    ```bash
    ./gradlew jibDockerBuild
    ```

1. Load the Docker image into the kind cluster:
    ```
    kind load docker-image cross-the-streams:0.0.1
    ```

1. Deploy to the kind cluster:
    ```bash
    kubectl apply -f k8s/
    ```

1. Access the `/speakers` REST API:
    ```bash
    curl -i http://localhost:8080/speakers
    ```
1. Launch JMeter and open `cross-the-streams.jmx`
