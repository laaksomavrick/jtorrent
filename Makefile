run:
	@java -classpath target/classes javap2p.Main

test:
	@mvn test

build:
	@mvn install
