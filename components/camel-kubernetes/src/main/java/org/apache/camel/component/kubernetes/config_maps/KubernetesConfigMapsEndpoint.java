/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.kubernetes.config_maps;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.component.kubernetes.AbstractKubernetesEndpoint;
import org.apache.camel.component.kubernetes.KubernetesConfiguration;
import org.apache.camel.component.kubernetes.build_configs.KubernetesBuildConfigsProducer;
import org.apache.camel.component.kubernetes.builds.KubernetesBuildsProducer;
import org.apache.camel.component.kubernetes.namespaces.KubernetesNamespacesConsumer;
import org.apache.camel.component.kubernetes.namespaces.KubernetesNamespacesProducer;
import org.apache.camel.component.kubernetes.nodes.KubernetesNodesConsumer;
import org.apache.camel.component.kubernetes.nodes.KubernetesNodesProducer;
import org.apache.camel.component.kubernetes.persistent_volumes.KubernetesPersistentVolumesProducer;
import org.apache.camel.component.kubernetes.persistent_volumes_claims.KubernetesPersistentVolumesClaimsProducer;
import org.apache.camel.component.kubernetes.pods.KubernetesPodsConsumer;
import org.apache.camel.component.kubernetes.pods.KubernetesPodsProducer;
import org.apache.camel.component.kubernetes.replication_controllers.KubernetesReplicationControllersConsumer;
import org.apache.camel.component.kubernetes.replication_controllers.KubernetesReplicationControllersProducer;
import org.apache.camel.component.kubernetes.resources_quota.KubernetesResourcesQuotaProducer;
import org.apache.camel.component.kubernetes.secrets.KubernetesSecretsProducer;
import org.apache.camel.component.kubernetes.service_accounts.KubernetesServiceAccountsProducer;
import org.apache.camel.component.kubernetes.services.KubernetesServicesConsumer;
import org.apache.camel.component.kubernetes.services.KubernetesServicesProducer;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.util.ObjectHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Kubernetes Configmaps component provides a producer to execute kubernetes configmap operations.
 */
@UriEndpoint(firstVersion = "2.17.0", scheme = "kubernetes-config-maps", title = "Kubernetes ConfigMap",
    syntax = "kubernetes-config-maps:masterUrl", producerOnly = true, label = "container,cloud,paas")
public class KubernetesConfigMapsEndpoint extends AbstractKubernetesEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(KubernetesConfigMapsEndpoint.class);

    public KubernetesConfigMapsEndpoint(String uri, KubernetesConfigMapsComponent component, KubernetesConfiguration config) {
        super(uri, component, config);
    }

    @Override
    public Producer createProducer() throws Exception {
        return new KubernetesConfigMapsProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        throw new IllegalArgumentException("The kubernetes-configmaps doesn't support consumer");
    }

}
