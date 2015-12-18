cf cups config-server -p '{"uri":"http://config-server-unvariegated-capitulary.cfapps.io/"}'
cf cups service-registry -p '{"uri":"http://eureka-psoatic-cirrocumulus.cfapps.io/"}'
cf cups circuit-breaker -p '{"uri":"http://circuit-breaker-cirrocumulus.cfapps.io/"}'
cf cs p-redis shared-vm redis