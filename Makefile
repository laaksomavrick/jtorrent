run:
	@java -classpath target/classes jtorrent.Main

test:
	@mvn test

build:
	@mvn install
