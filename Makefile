deploy:
	@play clean compile
	@play -Dconfig.file=conf/cloud.conf dist
	@cf push

.PHONY: deploy
