  /account:
    get:
      tags:
        - Account
      summary: ''
      description: ''
      operationId: getAccountById
      produces:
        - application/json
      parameters:
        - name: idAccount
          in: query
          description: idAccount
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Account'
    post:
      tags:
        - Account
      summary: ''
      description: ''
      operationId: createAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/AccountUpdate'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Account'
        '403':
          description: Forbidden
          schema:
            $ref: '#/definitions/Account'
  /account/updateAccount:
    put:
      tags:
        - Account
      summary: ''
      description: ''
      operationId: updateAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idAccount
          in: query
          required: true
          type: integer
          format: int32
        - name: newPassword
          in: query
          required: false
          type: string
        - name: newName
          in: query
          required: false
          type: string
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Account'
  /account/assignLineRole:
    put:
      tags:
        - Account
      summary: ''
      description: ''
      operationId: assignLineRole
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idAccount
          in: query
          required: true
          type: integer
          format: int32
        - name: idLine
          in: query
          required: true
          type: integer
          format: int32
        - name: idRole
          in: query
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
  /account/getAccounts:
    get:
      tags:
        - Account
      summary: ''
      description: ''
      operationId: getAccounts
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Account'
  /account/enableOrDisableAccount:
    put:
      tags:
        - Account
      summary: ''
      description: ''
      operationId: enableOrDisableAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idAccount
          in: query
          required: true
          type: integer
          format: int32
        - name: disable
          in: query
          required: true
          type: boolean
      responses:
        '200':
          description: successful operation
  /bom/BomWithRelations:
    get:
      tags:
        - bom
      summary: ''
      description: ''
      operationId: getBomWithRelations
      produces:
        - application/json
      parameters:
        - name: idBom
          in: query
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Bom'

  '/bom/{idBom}':
    get:
      tags:
        - bom
      summary: ''
      description: ''
      operationId: getBomById
      produces:
        - application/json
      parameters:
        - name: idBom
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Bom'
    put:
      tags:
        - bom
      summary: ''
      description: ''
      operationId: updateBom
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idBom
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/BomUpdate'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/BomUpdate'
  /bom:
    get:
      tags:
        - bom
      summary: ''
      description: ''
      operationId: getAllBoms
      produces:
        - application/json
      parameters:
        - name: idPart
          in: query
          required: false
          type: integer
          format: int32
        - name: idClient
          in: query
          required: false
          type: integer
          format: int32
        - name: partText
          in: query
          required: false
          type: string
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/BomUpdate'
    post:
      tags:
        - bom
      summary: ''
      description: ''
      operationId: createBom
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/BomUpdate'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/BomUpdate'
  '/bom/assignInputs/{idBom}':
    post:
      tags:
        - bom
      summary: 'Assign inputs to a bom'
      description: ''
      operationId: assignInputs
      produces:
        - application/json
      consumes:
        - application/json
    
    
      parameters:
        - name: idBom
          in: path
          required: true
          type: integer
          format: int32
        - name: inputs
          in: body
          required: true
          schema:
            type: array
            items:
              $ref: '#/definitions/CreateInputOutput'
      responses:
        '200':
          description: succesful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/InputOutput'
  '/bomDefinition/{idBomDefinition}':
    get:
      tags:
        - bomDefinition
      summary: ''
      description: ''
      operationId: getBomDefinitionById
      produces:
        - application/json
      parameters:
        - name: idBomDefinition
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/BomDefinition'
    put:
      tags:
        - bomDefinition
      summary: ''
      description: ''
      operationId: updateBomDefinition
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idBomDefinition
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/BomDefinition'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/BomDefinition'
  /bomDefinition:
    get:
      tags:
        - bomDefinition
      summary: ''
      description: ''
      operationId: getAllBomDefinitions
      produces:
        - application/json
      parameters:
        - name: idCell
          in: query
          required: false
          type: integer
          format: int32
        - name: idBom
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/BomDefinition'
  '/bomDefinition/assignationToCells/{idBom}':
    post:
      tags:
        - bomDefinition
      summary: ''
      description: 'Pending rename this function'
      operationId: assignationToCells
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idBom
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: bomDefinitions
          required: true
          schema:
            type: array
            items:
              $ref: '#/definitions/BomDefinitionIdealTc'
      responses:
        '200':
          description: successful operation
          schema:
        
     
   
   
    
   
    
      
    
    
    
    
   
    
   
     
   
            $ref: '#/definitions/BomDefinitionIdealTc'
  
   
       
   
        
  /cells:
    get:
      tags:
        - cell
      summary: ''
      description: ''
      operationId: getAllCells
      produces:
        - application/json
      parameters:
        - name: idLine
          in: query
          required: false
          type: integer
          format: int32
        - name: idStation
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Cell'
    post:
      tags:
        - cell
      summary: ''
      description: ''
      operationId: cellsPost
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Cell'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Cell'
  '/cells/{idCell}':
    get:
      tags:
        - cell
      summary: ''
      description: ''
      operationId: getCellById
      produces:
        - application/json
      parameters:
        - name: idCell
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Cell'
    put:
      tags:
        - cell
      summary: ''
      description: ''
      operationId: updateCell
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idCell
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Cell'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Cell'
  '/client/{idClient}':
    get:
      tags:
        - client
      summary: ''
      description: ''
      operationId: getClientById
      produces:
        - application/json
      parameters:
        - name: idClient
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Client'
    put:
      tags:
        - client
      summary: ''
      description: ''
      operationId: updateClient
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idClient
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Client'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Client'
  /client:
    get:
      tags:
        - client
      summary: ''
      description: ''
      operationId: getAllClients
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Client'
    post:
      tags:
        - client
      summary: ''
      description: ''
      operationId: createClient
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Client'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Client'
  /clientEvent:
    get:
      tags:
        - clientEvent
      summary: ''
      description: ''
      operationId: getAllClientEvents
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/ClientEvent'
    post:
      tags:
        - clientEvent
      summary: ''
      description: ''
      operationId: createClientEvent
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/ClientEvent'
      responses:
        '200':
          description: successful operation
  '/clientEvent/{idClientEvent}':
    get:
      tags:
        - clientEvent
      summary: ''
      description: ''
      operationId: getClientEventById
      produces:
        - application/json
      parameters:
        - name: idClientEvent
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/ClientEvent'
    put:
      tags:
        - clientEvent
      summary: ''
      description: ''
      operationId: updateClientEvent
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idClientEvent
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/ClientEvent'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/ClientEvent'
  '/design/{idDesign}':
    get:
      tags:
        - design
      summary: ''
      description: ''
      operationId: getDesignById
      produces:
        - application/json
      parameters:
        - name: idDesign
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Design'
    put:
      tags:
        - design
      summary: ''
      description: ''
      operationId: updateDesign
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idDesign
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Design'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Design'
  /design:
    get:
      tags:
        - design
      summary: ''
      description: ''
      operationId: getAllDesigns
      produces:
        - application/json
      parameters:
        - name: idProject
          in: query
          required: false
          type: integer
          format: int32
        - name: idVehicle
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Design'
    post:
      tags:
        - design
      summary: ''
      description: ''
      operationId: createDesign
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Design'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Design'
  '/designVersion/{idDesignVersion}':
    get:
      tags:
        - desingVersion
      summary: ''
      description: ''
      operationId: getDesignVersionById
      produces:
        - application/json
      parameters:
        - name: idDesignVersion
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/DesignVersion'
    put:
      tags:
        - desingVersion
      summary: ''
      description: ''
      operationId: updateDesignVersion
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idDesignVersion
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/DesignVersion'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/DesignVersion'
  /designVersion:
    get:
      tags:
        - desingVersion
      summary: ''
      description: ''
      operationId: getAllDesignVersions
      produces:
        - application/json
      parameters:
        - name: idDesign
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/DesignVersion'
    post:
      tags:
        - desingVersion
      summary: ''
      description: ''
      operationId: createDesignVersion
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/DesignVersion'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/DesignVersion'
  /groups:
    get:
      tags:
        - groups
      summary: ''
      description: ''
      operationId: getAllGroups
      produces:
        - application/json
      parameters:
        - name: idLine
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Group'
    post:
      tags:
        - groups
      summary: ''
      description: ''
      operationId: createGroup
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Group'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Group'
  '/groups/{idGroup}':
    get:
      tags:
        - groups
      summary: ''
      description: ''
      operationId: getGroupById
      produces:
        - application/json
      parameters:
        - name: idGroup
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Group'
    put:
      tags:
        - groups
      summary: ''
      description: ''
      operationId: updateGroup
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idGroup
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Group'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Group'
  /interval/getAllIntervalsRecords:
    get:
      tags:
        - interval
      summary: ''
      description: ''
      operationId: getAllIntervalsRecords
      produces:
        - application/json
      parameters:
        - name: idUnit
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: integer
            format: int32
    put:
      tags:
        - interval
      summary: ''
      description: ''
      operationId: updateInterval
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idInterval
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Interval'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Interval'
  /interval:
    post:
      tags:
        - interval
      summary: ''
      description: ''
      operationId: createInterval
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Interval'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Interval'
  /interval/getAllIntervals:
    get:
      tags:
        - interval
      summary: ''
      description: ''
      operationId: getAllIntervals
      produces:
        - application/json
      parameters:
        - name: idUnit
          in: query
          required: false
          type: integer
          format: int32
        - name: attribute
          in: query
          required: false
          type: string
        - name: limit
          in: query
          required: false
          type: integer
          format: int64
        - name: offset
          in: query
          required: false
          type: integer
          format: int64
        - name: page
          in: query
          required: false
          type: integer
          format: int64
        - name: value
          in: query
          required: false
          type: string
# Do not overwrite the following 7 lines up to @BeanParam compatible version
        - name: sort
          in: query
          required: false
          type: array
          items:
            type: string
          collectionFormat: multi
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Interval'
  /lineShiftSummary:
    get:
      tags:
        - lineShiftSummary
      summary: ''
      description: ''
      operationId: getLineShiftSummaries
      produces:
        - application/json
      parameters:
        - name: idLine
          in: query
          required: false
          type: integer
          format: int32
        - name: idLineShiftSummary
          in: query
          required: false
          type: integer
          format: int32
        - name: idShift
          in: query
          required: false
          type: integer
          format: int32
        - name: shiftDate
          in: query
          required: false
          type: string
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/LineShiftSummary'
  '/lineShiftSummary/current/{idLine}':
    get:
      tags:
        - lineShiftSummary
      summary: ''
      description: ''
      operationId: getCurrentLineShiftSummary
      produces:
        - application/json
      parameters:
        - name: idLine
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/LineShiftSummary'
  '/lineShiftSummary/{idLineShiftSummary}':
    get:
      tags:
        - lineShiftSummary
      summary: ''
      description: ''
      operationId: getLineShiftSummaryById
      produces:
        - application/json
      parameters:
        - name: idLineShiftSummary
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/LineShiftSummary'
  '/lineShiftSummary/previous/{idLineShiftSummary}':
    get:
      tags:
        - lineShiftSummary
      summary: ''
      description: ''
      operationId: getPreviousLineShiftSummary
      produces:
        - application/json
      parameters:
        - name: idLineShiftSummary
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/LineShiftSummary'
  /lines/getAllLineRecords:
    get:
      tags:
        - lines
      summary: ''
      description: ''
      operationId: getAllLineRecords
      produces:
        - application/json
      parameters:
        - name: idCell
          in: query
          required: false
          type: integer
          format: int32
        - name: idGroup
          in: query
          required: false
          type: integer
          format: int32
        - name: idPlant
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: integer
            format: int32
  /lines:
    get:
      tags:
        - lines
      summary: ''
      description: ''
      operationId: getAllLines
      produces:
        - application/json
      parameters:
        - name: idCell
          in: query
          required: false
          type: integer
          format: int32
        - name: idGroup
          in: query
          required: false
          type: integer
          format: int32
        - name: idPlant
          in: query
          required: false
          type: integer
          format: int32
        - name: attribute
          in: query
          required: false
          type: string
        - name: limit
          in: query
          required: false
          type: integer
          format: int64
        - name: offset
          in: query
          required: false
          type: integer
          format: int64
        - name: page
          in: query
          required: false
          type: integer
          format: int64
        - name: value
          in: query
          required: false
          type: string
# Do not overwrite the following 7 lines up to @BeanParam compatible version
        - name: sort
          in: query
          required: false
          type: array
          items:
            type: string
          collectionFormat: multi
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Line'
    post:
      tags:
        - lines
      summary: ''
      description: ''
      operationId: createLine
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Line'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Line'
  '/lines/{idLine}':
    get:
      tags:
        - lines
      summary: ''
      description: ''
      operationId: getLineById
      produces:
        - application/json
      parameters:
        - name: idLine
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Line'
    put:
      tags:
        - lines
      summary: ''
      description: ''
      operationId: updateLine
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idLine
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Line'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Line'
  '/organizations/{idOrganization}':
    get:
      tags:
        - organizations
      summary: ''
      description: ''
      operationId: getOrganizationById
      produces:
        - application/json
      parameters:
        - name: idOrganization
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Organization'
    put:
      tags:
        - organizations
      summary: ''
      description: ''
      operationId: updateOrganization
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idOrganization
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Organization'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Organization'
  /organizations/getAllOrganizationRecords:
    get:
      tags:
        - organizations
      summary: ''
      description: ''
      operationId: getAllOrganizationRecords
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: integer
            format: int32
  /organizations:
    get:
      tags:
        - organizations
      summary: ''
      description: ''
      operationId: getAllOrganizations
      produces:
        - application/json
      parameters:
        - name: attribute
          in: query
          required: false
          type: string
        - name: limit
          in: query
          required: false
          type: integer
          format: int64
        - name: offset
          in: query
          required: false
          type: integer
          format: int64
        - name: page
          in: query
          required: false
          type: integer
          format: int64
        - name: value
          in: query
          required: false
          type: string
# Do not overwrite the following 7 lines up to @BeanParam compatible version
        - name: sort
          in: query
          required: false
          type: array
          items:
            type: string
          collectionFormat: multi
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Organization'
    post:
      tags:
        - organizations
      summary: ''
      description: ''
      operationId: createOrganization
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Organization'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Organization'
  /package/getAllPackageRecords:
    get:
      tags:
        - package
      summary: ''
      description: ''
      operationId: getAllPackageRecords
      produces:
        - application/json
      parameters:
        - name: name
          in: query
          required: false
          type: string
          format: String
        - name: code
          in: query
          required: false
          type: string
          format: String
      responses:
        '200':
          description: successful operation
          schema:
            type: integer
            format: int32
  '/package/{idPackage}':
    get:
      tags:
        - package
      summary: ''
      description: ''
      operationId: getPackageById
      produces:
        - application/json
      parameters:
        - name: idPackage
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Package'
    put:
      tags:
        - package
      summary: ''
      description: ''
      operationId: updatePackage
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPackage
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Package'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Package'
  /package:
    get:
      tags:
        - package
      summary: ''
      description: ''
      operationId: getAllPackages
      produces:
        - application/json
      parameters:
        - name: name
          in: query
          required: false
          type: string
          format: String
        - name: code
          in: query
          required: false
          type: string
          format: String
        - name: attribute
          in: query
          required: false
          type: string
        - name: limit
          in: query
          required: false
          type: integer
          format: int64
        - name: offset
          in: query
          required: false
          type: integer
          format: int64
        - name: page
          in: query
          required: false
          type: integer
          format: int64
        - name: value
          in: query
          required: false
          type: string
# Do not overwrite the following 7 lines up to @BeanParam compatible version
        - name: sort
          in: query
          required: false
          type: array
          items:
            type: string
          collectionFormat: multi
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Package'
    post:
      tags:
        - package
      summary: ''
      description: ''
      operationId: createPackage
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Package'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Package'
  '/part/versions/{idPart}':
    get:
      tags:
        - part
      summary: ''
      description: ''
      operationId: getPartByIdWithVersions
      produces:
        - application/json
      parameters:
        - name: idPart
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/PartWithVersions'
  /part/ActivatePartVersion:
    put:
      tags:
        - part
      summary: ''
      description: ''
      operationId: activatePartVersion
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPartVersion
          in: query
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
  /part/DeactivatePartVersion:
    put:
      tags:
        - part
      summary: ''
      description: ''
      operationId: deactivatePartVersion
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPartVersion
          in: query
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
  '/part/updatePartVersion/{idPart}':
    put:
      tags:
        - part
      summary: ''
      description: ''
      operationId: updatePartVersion
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPart
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/UpdatePartVersion'
      responses:
        '201':
          description: successful operation
          schema:
            $ref: '#/definitions/PartWithVersions'
  '/part/NewVersion/{idPart}':
    put:
      tags:
        - part
      summary: ''
      description: ''
      operationId: createNewPartVersion
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPart
          in: path
          required: true
          type: integer
          format: int32
        - name: code
          in: query
          required: true
          type: string
      responses:
        '201':
          description: successful operation
  /part/addPackages:
    put:
      tags:
        - part
      summary: ''
      description: ''
      operationId: addPackage
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPart
          in: query
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            type: array
            items:
              $ref: '#/definitions/PartPackage'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Part'
  /part:
    get:
      tags:
        - part
      summary: ''
      description: ''
      operationId: getAllParts
      produces:
        - application/json
      parameters:
        - name: idDesign
          in: query
          required: false
          type: integer
          format: int32
        - name: idType
          in: query
          required: false
          type: integer
          format: int32
        - name: onlyActivedPartVersion
          in: query
          required: false
          type: boolean
        - name: code
          in: query
          required: false
          type: string
        - name: name
          in: query
          required: false
          type: string
        - name: limit
          in: query
          required: false
          type: integer
          format: int64
        - name: offset
          in: query
          required: false
          type: integer
          format: int64
   
     
     
    
    
    
     
     
     
# Do not overwrite the following 7 lines up to @BeanParam compatible version
        - name: sort
          in: query
          required: false
          type: array
          items:
            type: string
          collectionFormat: multi
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/PartExpanded'
    post:
      tags:
        - part
      summary: ''
      description: ''
      operationId: createPart
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: true
          schema:
            $ref: '#/definitions/CreatePart'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Part'
  /part/getAllRecords:
    get:
      tags:
        - part
      summary: ''
      description: ''
      operationId: getAllRecords
      produces:
        - application/json
      parameters:
        - name: idDesign
          in: query
          required: false
          type: integer
          format: int32
        - name: idType
          in: query
          required: false
          type: integer
          format: int32
        - name: code
          in: query
          required: false
          type: string
        - name: name
          in: query
          required: false
          type: string
        - name: onlyActivedPartVersion
          in: query
          required: false
          type: boolean
      responses:
        '200':
          description: successful operation
          schema:
            type: integer
            format: int32
  '/part/{idPart}':
    get:
      tags:
        - part
      summary: ''
      description: ''
      operationId: getPartById
      produces:
        - application/json
      parameters:
        - name: idPart
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Part'
    put:
      tags:
        - part
      summary: ''
      description: ''
      operationId: updatePart
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPart
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/UpdatePart'
      responses:
        '201':
          description: successful operation
          schema:
            $ref: '#/definitions/Part'
  '/partWithPackages/{idPart}':
    get:
      tags:
        - partWithPackages
      summary: ''
      description: ''
      operationId: getPartWithPackagesById
      produces:
        - application/json
      parameters:
        - name: idPart
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/PartWithPackage'
   
                         
  /parttype:
    get:
      tags:
        - PartType
      summary: ''
      description: ''
      operationId: getAllPartTypes
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/PartType'
  '/parttype/{idPartType}':
    get:
      tags:
        - PartType
      summary: ''
      description: ''
      operationId: getPartTypeById
      produces:
        - application/json
      parameters:
        - name: idPartType
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/PartType'
  /personals:
    get:
      tags:
        - personal
      summary: ''
      description: ''
      operationId: getAllPersonals
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Personal'
    post:
      tags:
        - personal
      summary: ''
      description: ''
      operationId: createPersonal
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Personal'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Personal'
  '/personals/{idPersonal}':
    get:
      tags:
        - personal
      summary: ''
      description: ''
      operationId: getPersonalById
      produces:
        - application/json
      parameters:
        - name: idPersonal
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Personal'
    put:
      tags:
        - personal
      summary: ''
      description: ''
      operationId: updatePersonal
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPersonal
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Personal'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Personal'
  /plants/getAllPlantRecords:
    get:
      tags:
        - plant
      summary: ''
      description: ''
      operationId: getAllPlantRecords
      produces:
        - application/json
      parameters:
        - name: idOrganization
          in: query
          required: false
          type: integer
          format: int32
        - name: idLine
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: integer
            format: int32
  /plants:
    get:
      tags:
        - plant
      summary: ''
      description: ''
      operationId: getAllPlants
      produces:
        - application/json
      parameters:
        - name: idOrganization
          in: query
          required: false
          type: integer
          format: int32
        - name: idLine
          in: query
          required: false
          type: integer
          format: int32
        - name: attribute
          in: query
          required: false
          type: string
        - name: limit
          in: query
          required: false
          type: integer
          format: int64
        - name: offset
          in: query
          required: false
          type: integer
          format: int64
        - name: page
          in: query
          required: false
          type: integer
          format: int64
        - name: value
          in: query
          required: false
          type: string
# Do not overwrite the following 7 lines up to @BeanParam compatible version
        - name: sort
          in: query
          required: false
          type: array
          items:
            type: string
          collectionFormat: multi
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Plant'
    post:
      tags:
        - plant
      summary: ''
      description: ''
      operationId: createPlant
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Plant'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Plant'
  '/plants/{idPlant}':
    get:
      tags:
        - plant
      summary: ''
      description: ''
      operationId: getPlantById
      produces:
        - application/json
      parameters:
        - name: idPlant
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Plant'
    put:
      tags:
        - plant
      summary: ''
      description: ''
      operationId: updatePlant
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idPlant
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Plant'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Plant'
  '/project/{idProject}':
    get:
      tags:
        - project
      summary: ''
      description: ''
      operationId: getProjectById
      produces:
        - application/json
      parameters:
        - name: idProject
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Project'
    put:
      tags:
        - project
      summary: ''
      description: ''
      operationId: updateProject
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idProject
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Project'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Project'
  /project:
    get:
      tags:
        - project
      summary: ''
      description: ''
      operationId: getAllProjects
      produces:
        - application/json
      parameters:
        - name: idClient
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Project'
    post:
      tags:
        - project
      summary: ''
      description: ''
      operationId: createProject
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Project'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Project'
  '/shift/{idShift}':
    get:
      tags:
        - shift
      summary: ''
      description: ''
      operationId: getShiftById
      produces:
        - application/json
      parameters:
        - name: idShift
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Shift'
    put:
      tags:
        - shift
      summary: ''
      description: ''
      operationId: updateShift
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idShift
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Shift'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Shift'
  /shift:
    get:
      tags:
        - shift
      summary: ''
      description: ''
      operationId: getAllShifts
      produces:
        - application/json
      parameters:
        - name: idPlant
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Shift'
    post:
      tags:
        - shift
      summary: ''
      description: ''
      operationId: createShift
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Shift'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Shift'
  '/stations/{stationId}':
    get:
      tags:
        - station
      summary: ''
      description: ''
      operationId: getStationById
      produces:
        - application/json
      parameters:
        - name: stationId
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Station'
    put:
      tags:
        - station
      summary: ''
      description: ''
      operationId: updateStation
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: stationId
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Station'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Station'
  /stations:
    get:
      tags:
        - station
      summary: ''
      description: ''
      operationId: getAllStations
      produces:
        - application/json
      parameters:
        - name: idCell
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Station'
    post:
      tags:
        - station
      summary: ''
      description: ''
      operationId: createStation
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Station'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Station'
  /supplier:
    get:
      tags:
        - supplier
      summary: ''
      description: ''
      operationId: getSupplierById
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: successful operation
  '/systemEvent/{idSystemEvent}':
    get:
      tags:
        - systemEvent
      summary: ''
      description: ''
      operationId: getSystemEventById
      produces:
        - application/json
      parameters:
        - name: idSystemEvent
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/SystemEvent'
    put:
      tags:
        - systemEvent
      summary: ''
      description: ''
      operationId: updateSystemEvent
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idSystemEvent
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/SystemEvent'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/SystemEvent'
  /systemEvent:
    get:
      tags:
        - systemEvent
      summary: ''
      description: ''
      operationId: getAllSystemEvents
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/SystemEvent'
    post:
      tags:
        - systemEvent
      summary: ''
      description: ''
      operationId: createSystemEvent
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/SystemEvent'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/SystemEvent'
  '/timeUnit/{idUnit}':
    get:
      tags:
        - timeUnit
      summary: ''
      description: ''
      operationId: getTimeUnitById
      produces:
        - application/json
      parameters:
        - name: idUnit
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/TimeUnit'
    put:
      tags:
        - timeUnit
      summary: ''
      description: ''
      operationId: updateTimeUnit
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idUnit
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/TimeUnit'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/TimeUnit'
  /timeUnit:
    get:
      tags:
        - timeUnit
      summary: ''
      description: ''
      operationId: getAllTimeUnits
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/TimeUnit'
    post:
      tags:
        - timeUnit
      summary: ''
      description: ''
      operationId: createTimeUnit
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/TimeUnit'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/TimeUnit'
  '/toolset/{idToolset}':
    get:
      tags:
        - toolset
      summary: ''
      description: ''
      operationId: getToolsetById
      produces:
        - application/json
      parameters:
        - name: idToolset
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Toolset'
    put:
      tags:
        - toolset
      summary: ''
      description: ''
      operationId: updateToolset
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idToolset
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Toolset'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Toolset'
  /toolset:
    get:
      tags:
        - toolset
      summary: ''
      description: ''
      operationId: getAllToolsets
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Toolset'
    post:
      tags:
        - toolset
      summary: ''
      description: ''
      operationId: createToolset
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Toolset'
      responses:
        '200':
          description: successful operation
  /unit/getAllUnitRecords:
    get:
      tags:
        - unit
      summary: ''
      description: ''
      operationId: getAllUnitRecords
      produces:
        - application/json
      parameters: []
      responses:
        '200':
          description: successful operation
          schema:
            type: integer
            format: int32
  '/unit/{idUnit}':
    get:
      tags:
        - unit
      summary: ''
      description: ''
      operationId: getUnitById
      produces:
        - application/json
      parameters:
        - name: idUnit
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Unit'
    put:
      tags:
        - unit
      summary: ''
      description: ''
      operationId: updateUnit
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idUnit
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Unit'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Unit'
  /unit:
    get:
      tags:
        - unit
      summary: ''
      description: ''
      operationId: getAllUnits
      produces:
        - application/json
      parameters:
        - name: attribute
          in: query
          required: false
          type: string
        - name: limit
          in: query
          required: false
          type: integer
          format: int64
        - name: offset
          in: query
          required: false
          type: integer
          format: int64
        - name: page
          in: query
          required: false
          type: integer
          format: int64
        - name: value
          in: query
          required: false
          type: string
# Do not overwrite the following 7 lines up to @BeanParam compatible version
        - name: sort
          in: query
          required: false
          type: array
          items:
            type: string
          collectionFormat: multi
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Unit'
    post:
      tags:
        - unit
      summary: ''
      description: ''
      operationId: createUnit
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Unit'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Unit'
  /vehicle:
    get:
      tags:
        - vehicle
      summary: ''
      description: ''
      operationId: getAllVehicles
      produces:
        - application/json
      parameters:
        - name: idProject
          in: query
          required: false
          type: integer
          format: int32
        - name: idDesign
          in: query
          required: false
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Vehicle'
    post:
      tags:
        - vehicle
      summary: ''
      description: ''
      operationId: createVehicle
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Vehicle'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Vehicle'
  '/vehicle/{idVehicle}':
    get:
      tags:
        - vehicle
      summary: ''
      description: ''
      operationId: getVehicleById
      produces:
        - application/json
      parameters:
        - name: idVehicle
          in: path
          required: true
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Vehicle'
    put:
      tags:
        - vehicle
      summary: ''
      description: ''
      operationId: updateVehicle
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - name: idVehicle
          in: path
          required: true
          type: integer
          format: int32
        - in: body
          name: body
          required: false
          schema:
            $ref: '#/definitions/Vehicle'
      responses:
        '200':
          description: successful operation
          schema:
            $ref: '#/definitions/Vehicle'
definitions:
  Account:
    type: object
    required:
         
      - idRealm
      - idStatus
      - name
    properties:
      idAccount:
        type: integer
        format: int32
        description: id Account
      idPersonal:
        type: integer
        format: int32
        description: id Personal
      idRealm:
        type: integer
        format: int32
        description: id Realm
      idStatus:
        type: integer
        format: int32
        description: id Status
      name:
        type: string
        description: name of Account
    description: Account Data Object
  AccountUpdate:
    type: object
    required:
         
      - name
      - password
    properties:
      idAccount:
        type: integer
        format: int32
        description: id Account
      name:
        type: string
        description: name of Account
      password:
        type: string
        description: password of Account
    description: This contains values to create or update a Account
  AccountLineRole:
    type: object
    required:
      - idAccount
      - idRealm
      - idStatus
      - name
    properties:
      idAccount:
        type: integer
        format: int32
        description: idAccount
      idPersonal:
        type: integer
        format: int32
        description: idPersonal
      idRealm:
        type: integer
        format: int32
        description: idRealm
      idStatus:
        type: integer
        format: int32
        description: idStatus
      name:
        type: string
        description: name
      lineRoles:
        type: array
        description: lineRoles
        readOnly: true
        items:
          $ref: '#/definitions/LineRole'
    description: This contains data from AccountLineRole entity
  LineRole:
    type: object
    properties:
      idLine:
        type: integer
        format: int32
        description: id Line
        readOnly: true
      idRole:
        type: integer
        format: int32
        description: id Role
        readOnly: true
    description: This contains data from LineRole entity
  Bom:
    type: object
    required:
      - inputs
      - name
      - outputs
    properties:
      idBom:
        type: integer
        format: int32
        description: idBom
      name:
        type: string
        description: name
      inputs:
        type: array
        description: inputs
        items:
          $ref: '#/definitions/InputOutput'
      outputs:
        type: array
        description: outputs
        items:
          $ref: '#/definitions/InputOutput'
    description: 'This contains Inputs, Outputs and nominalTc'
  CreateInputOutput:
    type: object
    required:
      - idPart
      - idBom
      - quantity
    properties:
      idPart:
        type: integer
        format: int32
      idBom:
        type: integer
        format: int32
        description: idBom
      quantity:
        type: integer
        format: int32
        description: quantity
    description: This is a model of Input or Output entity
  InputOutput:
    allOf:
      - $ref: '#/definitions/CreateInputOutput'
      - type: object
        required:
          - part
        properties:
          part:
            $ref: '#/definitions/PartWithPackage'
    description: This is a model of Input or Output entity
  Package:
    type: object
    required:
      - code
      - description
      - name
      - size
    properties:
      code:
        type: string
        description: code
      description:
        type: string
        description: description
      idPackage:
        type: integer
        format: int32
        description: id Package
      name:
        type: string
        description: name of Package
      size:
        type: string
        description: size of Package
    description: This contains values to create or update a Packages
  
  
  
   
  
    
   
    
   
   
       
    
    
    
     
  
    
    
     
   
    
    
     
  
    
    
      
     
   
   
     
    
    
    
      
     
   
    
    
        
     
    
     
      
     
   
       
        
   
  
  
    
    
   
    
   
    
   
    
    
       
   
    
    
    
  
    
    
      
     
    
    
       
  
    
    
     
   
       
      
          
  
  
  
   
   
   
    
    
   
    
    
    
   
   
     
  
     
     
   
       
   
     
     
   
       
  
   
     
     
       
  BomUpdate:
    type: object
    required:
      - name
    properties:
      idBom:
        type: integer
        format: int32
        description: idBom
      name:
        type: string
        description: name
    description: This contains values to create or update a Bom
  BomDefinition:
    type: object
    required:
      - active
      - idBom
      - idCell
      - locked
      - usual
    properties:
      active:
        type: boolean
        description: BomDefinition is active
      idBom:
        type: integer
        format: int32
        description: id Bom
      idBomDefinition:
        type: integer
        format: int32
        description: id Bom Definition
      idCell:
        type: integer
        format: int32
        description: id Cell
      locked:
        type: boolean
        description: BomDefinition is locked
      usual:
        type: boolean
        description: BomDefinition is usual
    description: This contains values to create or update a BomDefinition
  BomDefinitionIdealTc:
    type: object
    required:
      - bomDefinition
      - idealTc
    properties:
      bomDefinition:
       
     
        $ref: '#/definitions/BomDefinition'
      idealTc:
        type: number
        format: double
        description: idealTc
     
    description: This contains a bomDefinition model even idealTc value
  Cell:
    type: object
    required:
      - idLine
      - name
    properties:
      idCell:
        type: integer
        format: int32
        description: id Cell
      idLine:
        type: integer
        format: int32
        description: id Line
      name:
        type: string
        description: name
    description: This contains values to create or update a Cell
  Client:
    type: object
    required:
      - code
      - name
    properties:
      code:
        type: string
        description: code
      idClient:
        type: integer
        format: int32
        description: idClient
      idOrganization:
        type: integer
        format: int32
        description: idOrganization
      name:
        type: string
        description: name
    description: This contains values to create or update a Client
  ClientEvent:
    type: object
    required:
      - idClient
      - name
      - order
    properties:
      idClient:
        type: integer
        format: int32
        description: id Client
      idClientEvent:
        type: integer
        format: int32
        description: id Client Event
      name:
        type: string
        description: name of Client
      order:
        type: integer
        format: int32
        description: order
    description: This contains values to create or update a ClientEvent
  Design:
    type: object
    required:
      - code
      - name
    properties:
      code:
        type: string
        description: code
      idDesign:
        type: integer
        format: int32
        description: idDesign
      name:
        type: string
        description: name
    description: This contains values to create or update a Design
  DesignVersion:
    type: object
    required:
      - idDesign
      - revision
      - state
    properties:
      activation:
        type: string
        format: date-time
        description: activation
      deactivation:
        type: string
        format: date-time
        description: deactivation
      idDesign:
        type: integer
        format: int32
        description: idDesign
      idDesignVersion:
        type: integer
        format: int32
        description: idDesignVersion
      revision:
        type: integer
        format: int32
        description: revision
      state:
        type: integer
        format: int32
        description: state
    description: This contains values to create or update a DesignVersion
  Group:
    type: object
    required:
      - name
    properties:
      idGroup:
        type: integer
        format: int32
        description: idGroup
      name:
        type: string
        description: name
    description: This contains values to create or update a Group
  Interval:
    type: object
    required:
      - idUnit
      - name
      - special
      - unitQty
    properties:
      idInterval:
        type: integer
        format: int32
        description: id Interval
      idUnit:
        type: integer
        format: int32
        description: id Unit
      name:
        type: string
        description: name of unit
      special:
        type: boolean
        description: special
      unitQty:
        type: integer
        format: int32
        description: unitQty
    description: This contains values to create or update a Interval
  
  
  LineShiftSummary:
    type: object
    required:
      - idLine
      - idShift
      - shiftDate
    properties:
      idLine:
        type: integer
        format: int32
        description: idLine
      idLineShiftSummary:
        type: integer
        format: int32
        description: idLineShiftSummary
      idShift:
        type: integer
        format: int32
        description: idShift
      shiftDate:
        type: string
        format: date
        description: shiftDate
    description: This contains values to create or update a LineShiftSummary
  Line:
    type: object
    required:
      - idGroup
      - idPlant
      - name
      - nameGroup
      - namePlant
    properties:
      idGroup:
        type: integer
        format: int32
        description: id Group
      idLine:
        type: integer
        format: int32
        description: id Line
      idPlant:
        type: integer
        format: int32
        description: id Plant
      name:
        type: string
        description: name of Line
      nameGroup:
        type: string
        description: name of Group
      namePlant:
        type: string
        description: name of Plant
    description: This contains values to create or update a Line
  Organization:
    type: object
    required:
      - name
    properties:
      idOrganization:
        type: integer
        format: int32
        description: id Organization
      name:
        type: string
        description: name of Organization
    description: This contains values to create or update a Organization
  Part:
    type: object
    required:
      - code
      - idDesign
      - idPartType
      - name
    properties:
      code:
        type: string
        description: part version code
      idDesign:
        type: integer
        format: int32
        description: id Design
      idPart:
        type: integer
        format: int32
        description: id Part
      idPartType:
        type: integer
        format: int32
        description: id Type of Part
      idVersion:
        type: integer
        format: int32
        description: id of Version
        readOnly: true
      name:
        type: string
        description: name of part
      revision:
        type: integer
        format: int32
        description: revision of Version
        readOnly: true
      state:
        type: integer
        format: int32
        description: '0 = Disabled, 1 = Activated'
        readOnly: true
    description: This contains Part and their own packages
  PartWithPackage:
    allOf:
      - $ref: '#/definitions/Part'
      - type: object
        required:
          - packages
        properties:
          packages:
            type: array
            description: packages from Part
            readOnly: true
            items:
              $ref: '#/definitions/PartPackage'
  PartPackage:
    allOf:
      - $ref: '#/definitions/Package'
      - type: object
        required:
          - amountPackage
          - amountPart
          - idPart
          - idPackage
        properties:
          amountPackage:
            type: integer
            format: int32
            description: amount Package
          amountPart:
            type: integer
            format: int32
            description: amount Part
          idParentPackage:
            type: integer
            format: int32
            description: id Parent Package
          idPart:
            type: integer
            format: int32
            description: id Part
    description: This contains values to create or update a PartPackage
  PartVersion:
    type: object
    properties:
      activation:
        type: string
        format: date-time
        description: time of last activation
        readOnly: true
      code:
        type: string
        description: code of Part Version
        readOnly: true
      cost:
        type: number
        format: double
        description: cost of Version
        readOnly: true
      deactivation:
        type: string
        format: date-time
        description: time of last deactivation
        readOnly: true
      idPart:
        type: integer
        format: int32
        description: id Part
        readOnly: true
      idPartVersion:
        type: integer
        format: int32
        description: id Part Version
        readOnly: true
      revision:
        type: integer
        format: int32
        description: revision
        readOnly: true
      state:
        type: integer
        format: int32
        description: state
        readOnly: true
    description: This contains a basic values to create or update a PartVersion
  PartWithVersions:
    allOf:
      - $ref: '#/definitions/Part'
   
      - type: object
        required:
          - versions
        properties:
   
          versions:
            type: array
            description: versions
            readOnly: true
            items:
              $ref: '#/definitions/PartVersion'
    description: This contains Part and their own Versions
  UpdatePartVersion:
    type: object
    required:
      - code
      - idPart
      - idPartVersion
    properties:
      code:
        type: string
        description: code
      idPart:
        type: integer
        format: int32
        description: idPart
      idPartVersion:
        type: integer
        format: int32
        description: idPartVersion
    description: This Model updates a PartVersion entity
  PartExpanded:
    allOf:
      - $ref: '#/definitions/Part'
      - type: object
        properties:
          design:
            $ref: '#/definitions/Design'
          partType:
            $ref: '#/definitions/PartType'
    description: This contains Part model and extends with more values
  CreatePart:
    type: object
    required:
      - code
      - name
      - idDesign
      - idPartType
    properties:
      code:
        type: string
        description: code of version
      name:
        type: string
        description: name of part
      idDesign:
        type: integer
        format: int32
        description: id Design
      idPartType:
        type: integer
        format: int32
        description: id Part Type
    description: This Model creates a Part entity with an actived version
  UpdatePart:
    type: object
    required:
      - idDesign
      - idPart
      - idPartType
      - name
    properties:
      idDesign:
        type: integer
        format: int32
        description: id Design
      idPart:
        type: integer
        format: int32
        description: id Part
      idPartType:
        type: integer
        format: int32
        description: id Part Type
      name:
        type: string
        description: name of part
      code:
        type: string
        description: code of actived version
    description: This Model updates a Part entity
  PartType:
    type: object
    properties:
      idPartType:
        type: integer
        format: int32
        description: id PartType
      name:
        type: string
        description: name of Type
    description: This contains a PartType values
  Personal:
    type: object
    required:
      - idContact
      - idOrganization
      - name
    properties:
      idContact:
        type: integer
        format: int32
        description: id Contact
      idOrganization:
        type: integer
        format: int32
        description: id Organization
      idPersonal:
        type: integer
        format: int32
        description: id Personal
      name:
        type: string
        description: name of Personal
    description: This contains values to create or update a Personal
  Plant:
    type: object
    required:
      - idOrganization
      - name
      - timeZone
    properties:
      idOrganization:
        type: integer
        format: int32
        description: id Organization
      idPlant:
        type: integer
        format: int32
        description: id Plant
      name:
        type: string
        description: name of Plant
      nameOrganization:
        type: string
        description: name of Organization
      timeZone:
        type: string
        description: Plant timeZone
    description: This contains values to create or update a Plant
  Project:
    type: object
    required:
      - code
      - idClient
      - name
    properties:
      code:
        type: string
        description: code of Project
      idClient:
        type: integer
        format: int32
        description: id Client
      idProject:
        type: integer
        format: int32
        description: id Project
      name:
        type: string
        description: name of Project
    description: This contains values to create or update a Project
  LocalTime:
    type: object
    properties:
      hour:
        type: integer
        format: int32
      minute:
        type: integer
        format: int32
      second:
        type: integer
        format: int32
      nano:
        type: integer
        format: int32
  Shift:
    type: object
    required:
      - endTime
      - idPlant
      - name
      - productionOffsetHours
      - startTime
    properties:
      endTime:
        $ref: '#/definitions/LocalTime'
      idPlant:
        type: integer
        format: int32
        description: idPlant
      idShift:
        type: integer
        format: int32
        description: idShift
      name:
        type: string
        description: name
      productionOffsetHours:
        type: integer
        format: int32
        description: productionOffsetHours
      startTime:
     
        $ref: '#/definitions/LocalTime'
    description: This contains values to create or update a Shift
  Station:
    type: object
    required:
      - idCell
      - name
    properties:
      idCell:
        type: integer
        format: int32
        description: id Cell
      idStation:
        type: integer
        format: int32
        description: id Station
      name:
        type: string
        description: name of Station
    description: This contains values to create or update a Station
  SystemEvent:
    type: object
    required:
      - name
    properties:
      idSystemEvent:
        type: integer
        format: int32
        description: id System Event
      name:
        type: string
        description: name of System Event
    description: This contains values to create or update a SystemEvent
  TimeUnit:
    type: object
    required:
      - secondsPerUnit
    properties:
      idUnit:
        type: integer
        format: int32
        description: id Unit
      secondsPerUnit:
        type: integer
        format: int32
        description: seconds Per Unit
    description: This contains values to create or update a TimeUnit
  Toolset:
    type: object
    required:
      - name
    properties:
      idToolset:
        type: integer
        format: int32
        description: id Toolset
      name:
        type: string
        description: name of Toolset
    description: This contains values to create or update a Toolset
  Unit:
    type: object
    required:
      - abbreviation
      - name
    properties:
      abbreviation:
        type: string
        description: abbreviation
      idUnit:
        type: integer
        format: int32
        description: idUnit
      name:
        type: string
        description: name
    description: This contains values to create or update a Unit
  Vehicle:
    type: object
    required:
      - idProject
      - name
    properties:
      idProject:
        type: integer
        format: int32
        description: idProject
      idVehicle:
        type: integer
        format: int32
        description: idVehicle
      name:
        type: string
        description: name
    description: This contains values to create or update a Vehicle