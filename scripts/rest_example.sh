# Create a task
cat <<EOF | curl -H "Content-Type: application/json" -X POST -d @- http://localhost:8081/api/tasks
{
    "workflowId" : "wf-1",
    "entityId": "entity-1",
    "userId": "user-1",
    "type": "approval",
    "url": "http://localhost:4200/entity-detail/entity-1",
    "date": "2019-03-20"
}
EOF

# Get all task
curl -H "Content-Type: application/json" http://localhost:8081/api/tasks

# Get a task
curl -H "Content-Type: application/json" http://localhost:8081/api/tasks/1

# Update a task
cat <<EOF | curl -H "Content-Type: application/json" -X PUT -d @- http://localhost:8081/api/tasks/1
{
    "status" : "completed"
}
EOF

# Create a notification
cat <<EOF | curl -H "Content-Type: application/json" -X POST -d @- http://localhost:8081/api/notifications
{
    "workflowId" : "wf-1",
    "entityId": "entity-1",
    "message": "A notification message..."
}
EOF

# Get all notifications
curl -H "Content-Type: application/json" http://localhost:8081/api/notifications

# Get a notification
curl -H "Content-Type: application/json" http://localhost:8081/api/notifications/1
