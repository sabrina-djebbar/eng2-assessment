/*
 * C4 model at the system and container levels for the To-Do Microservice,
 * using the Structurizr DSL from here:
 *
 *   https://docs.structurizr.com/dsl/
 *
 * The Compose file in this repository includes a container that runs the
 * Structurizr Lite web application. Use "./compose-it.sh up -d" to bring
 * up the application, and open this webpage:
 *
 *   http://localhost:8081/
 */
workspace "Video Sharing" "Example Video Sharing list system" {

    model {
      u = person "User"
      s = softwareSystem "Video sharing System" {
          cli = container "Video Sharing CLI Client"
          video_microservice = container "Video Microservice" {
            video_domain = component "Domain objects and DTOs"
            video_services = component "Services"
            video_repos = component "Repositories"
            video_events = component "Kafka consumers and producers"
            video_resources = component "Resources"
          }
        
        trending_microservice = container "Trending Microservice" {
            trending_domain = component "Domain objects and DTOs"
            trending_services = component "Services"
            trending_repos = component "Repositories"
            trending_events = component "Kafka consumers and producers"
            trending_resources = component "Resources"
          }
subscription_microservice = container "Subscription Microservice" {
            subscription_domain = component "Domain objects and DTOs"
            subscription_services = component "Services"
            subscription_repos = component "Repositories"
            subscription_events = component "Kafka consumers and producers"
            subscription_resources = component "Resources"
          }
          video_database = container "Video Database" "" "MariaDB" "database" 
          trending_database = container "Trending Hashtag Database" "" "MariaDB" "database"
          subscription_database = container "Subscription Database" "" "MariaDB" "database"
          kafka = container "Kafka Cluster"
        
      }

      u -> cli "Uses"
  

      cli -> video_microservice "Interacts with HTTP API"

      video_microservice -> video_database "Reads from and writes to"
      video_microservice -> kafka "Produces events"
    
      video_repos -> video_domain "Creates and updates"
      video_repos -> video_database "Queries and writes to"
      video_services -> video_domain "Runs business workflows on"
      video_services -> video_repos "Uses"
      video_resources -> video_repos "Uses"
      video_resources -> video_events "Uses"
     
      video_resources -> video_services "Uses"
      video_resources -> video_domain "Reads and updates"
     
      cli -> video_resources "Invokes"
      video_events -> kafka "Produces events in"

      cli -> trending_microservice "Interacts with HTTP API"

      trending_microservice -> trending_database "Reads from and writes to"
      trending_microservice -> kafka "Consumes events"
    
      trending_repos -> trending_domain "Creates and updates"
      trending_repos -> trending_database "Queries and writes to"
      trending_services -> trending_domain "Runs business workflows on"
      trending_services -> trending_repos "Uses"
      trending_resources -> trending_repos "Uses"
      trending_resources -> trending_events "Uses"
     
      trending_resources -> trending_services "Uses"
      trending_resources -> trending_domain "Reads and updates"
     
      cli -> trending_resources "Invokes"
      trending_events -> kafka "Consumes events in"

      cli -> subscription_microservice "Interacts with HTTP API"

      subscription_microservice -> subscription_database "Reads from and writes to"
      subscription_microservice -> kafka "Consumes and produces events"
    
      subscription_repos -> subscription_domain "Creates and updates"
      subscription_repos -> subscription_database "Queries and writes to"
      subscription_services -> subscription_domain "Runs business workflows on"
      subscription_services -> subscription_repos "Uses"
      subscription_resources -> subscription_repos "Uses"
      subscription_resources -> subscription_events "Uses"
     
      subscription_resources -> subscription_services "Uses"
      subscription_resources -> subscription_domain "Reads and updates"
     
      cli -> subscription_resources "Invokes"
      subscription_events -> kafka "Consumes and produces events in"
    }

    views {
        theme default
        systemContext s {
            include *
        }
        container s {
            include *
        }
        component video_microservice {
            include *
        }
        component trending_microservice {
            include *
        }
        component subscription_microservice {
            include *
        }
        styles {
            element "video_database" {
              shape Cylinder
            }
            element "webapp" {
              shape WebBrowser
            }
            element external {
              background gray
            }
        }
    }

}