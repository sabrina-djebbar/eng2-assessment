workspace "Video" "Example Video social media system" {

    model {
      u = person "User"
      video = softwareSystem "Video System" {
          cli = container "Video CLI Client"

          micronaut = container "Video Microservice" {
            domain = component "Domain objects and DTOs"
            services = component "Services"
            repos = component "Repositories"
            events = component "Kafka producers"
            resources = component "Resources"
          }

          database = container "Video Database" "" "MariaDB" "database"
          kafka = container "Kafka Cluster"
          kafkaui = container "Kafka-UI Webapp" "" "" webapp
          adminer = container "Adminer Webapp" "" "" webapp
      }
      currency = softwareSystem "Hashtag System" {
        tags external
      }

      video -> currency "Invokes API"

      u -> cli "Uses"
     
      cli -> micronaut "Interacts with HTTP API"

      micronaut -> database "Reads from and writes to"
      micronaut -> kafka "Consumes and produces events"
      micronaut -> currency "Invokes API"

      kafkaui -> kafka "Manages"
      repos -> domain "Creates and updates"
      repos -> database "Queries and writes to"
      services -> domain "Runs business workflows on"
      services -> repos "Uses"
      resources -> repos "Uses"
      resources -> events "Uses"
    
      resources -> services "Uses"
      resources -> domain "Reads and updates"
      
      cli -> resources "Invokes"
      events -> kafka "Produces events in"
    }

    views {
        theme default
        systemContext video {
            include *
        }
        container video {
            include *
        }
        component micronaut {
            include *
        }
        styles {
            element "database" {
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