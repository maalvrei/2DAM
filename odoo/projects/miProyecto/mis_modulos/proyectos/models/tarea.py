from odoo import fields, models

class Tarea(models.Model):
    _name = "proyectos.tarea"  
    _description = 'Tarea' 
    name = fields.Char(string='Nombre')
    description = fields.Text(string='Descripción')
    start_date = fields.Date(string='Fecha de inicio')
    end_date = fields.Date(string='Fecha de vencimiento')
    priority = fields.Selection(selection=[
        ('A','Alta'),
        ('M', 'Media'),
        ('B','Baja'),
    ],string='Prioridad de la tarea')
    state = fields.Selection(selection=[
        ('N', 'Nuevo'), # Público general
        ('EP', 'En progreso'), # Se recomienda la compañía de un adulto
        ('T', 'Terminado'), # Mayores de 13 
    ],string='Estado de la tarea')
    proyecto_id = fields.Many2one('proyectos.proyecto', string='Proyecto')
    assigned_user_ids = fields.Many2many('res.users',string='Asignado a')
    estimated_hours = fields.Float(string='Horas estimadas')
    spent_hours = fields.Float(string='Horas dedicadas')
    comments = fields.One2many('proyectosplus.comentario', 'task_id', string='Comentarios')
    registros = fields.One2many('proyectosplus.registro_tiempo', 'task_id', string='Registros de tiempo')
    

class Comentario(models.Model):
    _inherit = "proyectosplus.comentario"
    task_id = fields.Many2one('proyectos.tarea',string='Tarea asociada')

class Registro(models.Model):
    _inherit="proyectosplus.registro_tiempo"
    task_id = fields.Many2one('proyectos.tarea', string='Tarea asociada')