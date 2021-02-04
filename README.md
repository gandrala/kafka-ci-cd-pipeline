steps:
  # need checkout before using compose-action
  - uses: actions/checkout@v2
  - uses: isbang/compose-action@v0.1
    with:
      compose-file: './docker/docker-compose.yml'

    - name: Set up Maven
      uses: aahmed-se/setup-maven@v3
      with:
        maven-version: 3.6.1

action "package" {
  uses = "LucaFeger/action-maven-cli@master"
  args = "clean install"
}


jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v2
    - name: Set up JDK 1.8
      uses: actions/setup-java@v1
      with:
        java-version: 1.8

    - name: Build with Maven
      run: mvn -B package --file pom.xml


jobs:
  build:
    runs-on: ubuntu-16.04
    strategy:
      matrix:
        # test against latest update of each major Java version, as well as specific updates of LTS versions:
        java: [ 1.6, 6.0.83, 7, 7.0.181, 8, 8.0.192, 9.0.x, 10, 11.0.x, 11.0.3, 12, 13 ]
    name: Java ${{ matrix.java }} sample
    steps:
      - uses: actions/checkout@v2
      - name: Setup java
        uses: actions/setup-java@v1
        with:
          java-version: ${{ matrix.java }}
      - run: java -cp java HelloWorldApp

 steps:
- uses: actions/checkout@v2
- uses: joschi/setup-jdk@v2
  with:
    java-version: '11' # The OpenJDK version to make available on the path
    architecture: 'x64' # defaults to 'x64'
- run: java -cp java HelloWorldApp


jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v2
    - name: Set up JDK 1.8
      uses: joschi/setup-jdk@v2
      with:
        java-version: '8'

    - name: Build with Maven
      run: mvn -B package --file pom.xml

    - name: Publish to GitHub Packages Apache Maven
      run: mvn deploy
      env:
        GITHUB_TOKEN: ${{ github.token }} # GITHUB_TOKEN is the default env for the password

name: My Workflow

on: [push]

jobs:
  runMultipleCommands:
    runs-on: ubuntu-latest
    steps:
     - uses: actions/checkout@v1
     - run: |
        echo "A initial message"
        pip install -r requirements.txt
        echo "Another message or command"
        python myscript.py
        bash some-shell-script-file.sh -xe
     - run: echo "One last message"

- name: Build with Maven
      run: mvn -B package
    - name: Build local image
      run: docker build -f Dockerfile.mvn --tag <name>:<tag>.
    - name: Build the stack
      run: docker-compose --env-file=env/local/Docker.env up -d
    - name: Test
      run: |
        sleep 120
        docker run --network container:<container-name> appropriate/curl -s --retry 10 --retry-connrefused http://localhost:8080/actuator/health

 name: CI

on:
  pull_request:
    branches: [ master ]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-node@v1
      - name: Install
        run: npm ci
      - name: Linter
        run: npm run lint
      - name: Build
        run: npm run build
      - name: Docker
        run: docker-compose up -d
      - name: Wait / Sleep
        uses: jakejarvis/wait-action@v0.1.0
        with:
          time: '10s'
      - run: | 
          docker ps
          cat ./dumps/backup.sql | docker exec -i mysql-development_1 /usr/bin/mysql -u root --password=password        
      - name: Test
        run: npm test

curl "https://apache.mirror.digitalpacific.com.au/kafka/2.7.0/kafka_2.13-2.7.0.tgz" -o ~/Downloads/kafka.tgz
mkdir ~/kafka && cd ~/kafka
tar -xvzf ~/Downloads/kafka.tgz --strip 1


/Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 -classpath /Users/subbugandrala/Documents/Work/code/basic-kafka/target/classes:/Users/subbugandrala/.m2/repository/org/apache/kafka/kafka-clients/2.6.0/kafka-clients-2.6.0.jar:/Users/subbugandrala/.m2/repository/com/github/luben/zstd-jni/1.4.4-7/zstd-jni-1.4.4-7.jar:/Users/subbugandrala/.m2/repository/org/lz4/lz4-java/1.7.1/lz4-java-1.7.1.jar:/Users/subbugandrala/.m2/repository/org/xerial/snappy/snappy-java/1.1.7.3/snappy-java-1.1.7.3.jar:/Users/subbugandrala/.m2/repository/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar:/Users/subbugandrala/.m2/repository/org/slf4j/slf4j-simple/1.7.26/slf4j-simple-1.7.26.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.11.3/jackson-databind-2.11.3.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.11.3/jackson-annotations-2.11.3.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.11.3/jackson-core-2.11.3.jar com.kafka.local.Consumer

eclipse run maven
/Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 -classpath /Users/subbugandrala/Documents/Work/code/basic-kafka/target/classes:/Users/subbugandrala/.m2/repository/org/apache/kafka/kafka-clients/2.6.0/kafka-clients-2.6.0.jar:/Users/subbugandrala/.m2/repository/com/github/luben/zstd-jni/1.4.4-7/zstd-jni-1.4.4-7.jar:/Users/subbugandrala/.m2/repository/org/lz4/lz4-java/1.7.1/lz4-java-1.7.1.jar:/Users/subbugandrala/.m2/repository/org/xerial/snappy/snappy-java/1.1.7.3/snappy-java-1.1.7.3.jar:/Users/subbugandrala/.m2/repository/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar:/Users/subbugandrala/.m2/repository/org/slf4j/slf4j-simple/1.7.26/slf4j-simple-1.7.26.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.11.3/jackson-databind-2.11.3.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.11.3/jackson-annotations-2.11.3.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.11.3/jackson-core-2.11.3.jar com.kafka.local.Consumer
