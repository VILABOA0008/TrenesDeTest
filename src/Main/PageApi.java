
  /report:
    get:
      tags:
        - Report
      summary: 'get reports'
      description: 'get reports'
      operationId: getAll
      produces:
        - application/json
      parameters:
        - name: idReport
          in: query
          required: false
          type: integer
          format: int32
        - name: startDate
          in: query
          required: false
          type: string
          format: date
        - name: endDate
          in: query
          required: false
          type: string
          format: date
        - name: name
          in: query
          required: false
          type: string
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Report'
    post:
      tags:
        - Report
      summary: 'create a new Report'
      description: 'create a new Report'
      operationId: createReport
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: true
          schema:
            $ref: '#/definitions/CreateReport'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Report'
  /report-type:
    get:
      tags:
        - Report Type
      summary: 'get types'
      description: 'get types'
      operationId: getAllTypes
      produces:
        - application/json
      parameters:
        - name: idReport
          in: query
          required: false
          type: integer
          format: int32
        - name: name
          in: query
          required: false
          type: string
        - name: parameters
          in: query
          required: false
          type: string
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Report'
definitions:
  ReportType:
    type: object
    properties:
      idReportType:
        type: integer
        format: int32
        description: id Report type
        readOnly: true
      name:
        type: string
        description: name of type
        readOnly: true
      parameters:
        type: string
        description: parameters of type
        readOnly: true
    description: This contains data of Report Type
  CreateReport:
    type: object
    required:
      - idReportType
      - name
      - startDate
    properties:
      idReportType:
        type: integer
        format: int32
      startDate:
        type: string
        format: date
      endDate:
        type: string
        format: date
      name:
        type: string
    description: This contains data to create a new Report
  Report:
    type: object
    properties:
      idReport:
        type: integer
        format: int32
        readOnly: true
      reportType:
        $ref: '#/definitions/ReportType'
      startDate:
        type: string
        format: date
        readOnly: true
      endDate:
        type: string
        format: date
        readOnly: true
      name:
        type: string
        readOnly: true
    description: This contains Report data
  