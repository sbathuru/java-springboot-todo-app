
#### 
 $ helm create javaspringboottodo

####
Convert and Update Chart.yaml, deployment.yaml, service.yaml and values.yaml

#### Shows Runtime version of yml files
helm template javaspringboottodo

#### lint which will tell you if there are any syntactical errors in the YAMls.
helm lint javaspringboottodo      

#### install the Helm Chart
helm install javaspringboottodo javaspringboottodo
helm uninstall javaspringboottodo