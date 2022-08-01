### springboot-crud-k8s
 Run &amp; Deploy Spring Boot CRUD Application With MySQL on K8S

#### -----------Install/Deploy----------------------------------
##### Method 1
 $ helm install springboot-crud-k8s  springboot-crud-k8s
 $ helm upgrade springboot-crud-k8s  springboot-crud-k8s

##### Method 2
 $ helm install springboot-crud-k8s  springboot-crud-k8s
 $ helm upgrade springboot-crud-k8s  springboot-crud-k8s

#### -----------Troubleshoot-----------------------------------
 $ kubectl get all --all-namespaces
 $ helm show values prometheus-community/kube-prometheus-stack  

#### -----------Uninstall/Cleanup-------------------------------
 $ helm uninstall springboot-crud-k8s

 $ helm repo add springboot-crud-k8s https://sbathuru.github.io/springboot-crud-k8s/charts
 $ helm install springboot-crud-k8s  springboot-crud-k8s/


