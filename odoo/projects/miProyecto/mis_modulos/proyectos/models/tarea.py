from odoo import fields, models

class Tarea(models.Model):
		# El nombre técnico del modelo
		# Usualmente en formato 'nombre_del_modulo.nombre_del_modelo' 
    _name = "proyectos.tarea"  
		# Una descripción para el modelo
    _description = 'Tarea' 
		# Se define un primer campo de ejemplo llamado name 
		# 'string' es opcional y define el nombre del campo en la vista
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


   